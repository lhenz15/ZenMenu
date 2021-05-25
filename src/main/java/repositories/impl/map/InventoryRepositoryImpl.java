package repositories.impl.map;

import entities.Inventory;
import repositories.IGenericRepository;
import repositories.InventoryRepository;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InventoryRepositoryImpl implements InventoryRepository {

    final private Map<Long, Inventory> inventories = new HashMap<>();
    private long inventoryId = 1;

    @Override
    public void add(Inventory inventory) {
        inventory.setId(inventoryId++);
        inventories.put(inventory.getId(), inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return Optional.ofNullable(inventories.replace(inventory.getId(), inventory)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Inventory delete(Long id) {
        return Optional.ofNullable(inventories.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Inventory find(Long id) {
        return Optional.ofNullable(inventories.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Inventory> findAll() {
        return inventories.values().stream().collect(Collectors.toList());
    }
}
