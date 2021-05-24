package repositories;

import entities.Item;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemRepository implements IGenericRepository<Item, Long> {

    final private Map<Long, Item> items = new HashMap<>();
    private int itemId = 1;

    @Override
    public void add(Item item) {
        item.setId(itemId++);
        items.put(item.getId(), item);
    }

    @Override
    public Item update(Item item) {
        return Optional.ofNullable(items.replace(item.getId(), item)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Item delete(Long id) {
        return Optional.ofNullable(items.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Item find(Long id) {
        return Optional.ofNullable(items.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Item> findAll() {
        return items.values().stream().collect(Collectors.toList());
    }
}
