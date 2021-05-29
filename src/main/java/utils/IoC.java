package utils;

import controllers.ItemController;
import entities.Item;
import exceptions.DuplicatedKeyException;
import exceptions.InstanceNotFoundException;
import repositories.impl.map.*;

import java.util.HashMap;
import java.util.Map;

public class IoC {

    private static IoC instance;
    private static Map<String, Object> instanceMap = new HashMap<>();

    private void initRepositories(){
        putInstance("ItemRepository", new ItemRepositoryImpl());
        putInstance("InventoryRepository", new InventoryRepositoryImpl());
        putInstance("InventoryItemRepository", new InventoryItemRepositoryImpl());
        putInstance("MenuRepository", new MenuRepositoryImpl());
        putInstance("ProductRepository", new ProductRepositoryImpl());
        putInstance("OrderRepository", new OrderRepositoryImpl());
        putInstance("OrderDetailRepository", new OrderDetailRepositoryImpl());
        putInstance("OrderPaymentRepository", new OrderPaymentRepositoryImpl());
    }

    private IoC(){
        initRepositories();
    };

    public static IoC getInstance(){
        if(instance == null)
            instance = new IoC();

        return instance;
    }

    public <T> T getInstance(String key){
        if(instanceMap.containsKey(key))
            return (T) instanceMap.get(key);

        throw new InstanceNotFoundException();
    }

    public <T> void putInstance(String key, T instance) {
        if(instanceMap.containsKey(key))
            throw new DuplicatedKeyException();

        instanceMap.put(key, instance);
    }
}
