package repositories;

import entities.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository implements IGenericRepository<Item> {

    private Map<Integer, Item> items = new HashMap<>();
    private int itemId = 1;

    @Override
    public void add(Item item) {
        item.setId(itemId);
        items.put(item.getId(), item);

        itemId++;
    }

    @Override
    public Item update(Item item) {
        if (item != null && items.containsKey(item.getId())) {
            return items.replace(item.getId(), item);
        }

        return null;
    }

    @Override
    public Item delete(Integer id) {
        if (id != null && items.containsKey(id)) {
            return items.remove(id);
        }

        return null;
    }

    @Override
    public Item find(Integer id) {
        if (id != null && items.containsKey(id)) {
            return items.get(id);
        }

        return null;
    }

    @Override
    public Iterable<Item> findAll() {
        return items.values();
    }
}
