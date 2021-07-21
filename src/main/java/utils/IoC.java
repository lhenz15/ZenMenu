package utils;

import controllers.*;
import exceptions.DuplicatedKeyException;
import exceptions.InstanceNotFoundException;
import repositories.impl.map.*;

import java.util.HashMap;
import java.util.Map;

public class IoC {

    private static IoC instance;
    private static Map<String, Object> instanceMap = new HashMap<>();

    private IoC(){
        initRepositories();
        initControllers();
    };

    private void initRepositories(){
        putInstance("ItemRepository", new ItemRepositoryImpl());
        putInstance("InventoryRepository", new InventoryRepositoryImpl());
        putInstance("InventoryItemRepository", new InventoryItemRepositoryImpl());
        putInstance("MenuRepository", new MenuRepositoryImpl());
        putInstance("ProductRepository", new ProductRepositoryImpl());
        putInstance("OrderRepository", new OrderRepositoryImpl());
        putInstance("OrderDetailRepository", new OrderDetailRepositoryImpl());
        putInstance("OrderPaymentRepository", new OrderPaymentRepositoryImpl());
        putInstance("WaiterRepository", new WaiterRepositoryImpl());
        putInstance("ChefRepository", new ChefRepositoryImpl());
    }

    private void initControllers(){
        putInstance("ItemController", new ItemController(getInstance("ItemRepository")));
        putInstance("InventoryController", new InventoryController(getInstance("InventoryRepository")));
        putInstance("InventoryItemController", new InventoryItemController(getInstance("InventoryItemRepository")));
        putInstance("MenuController", new MenuController(getInstance("MenuRepository")));
        putInstance("ProductController", new ProductController(getInstance("ProductRepository")));
        putInstance("OrderController", new OrderController(getInstance("OrderRepository")));
        putInstance("OrderDetailController", new OrderDetailController(getInstance("OrderDetailRepository")));
        putInstance("OrderPaymentController", new OrderPaymentController(getInstance("OrderPaymentRepository")));
        putInstance("WaiterController", new WaiterController(getInstance("WaiterRepository")));
        putInstance("ChefController", new ChefController(getInstance("ChefRepository")));
    }

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
