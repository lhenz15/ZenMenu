package repositories.impl.map;

import entities.InventoryItem;
import repositories.InventoryItemRepository;
import exceptions.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InventoryItemRepositoryImpl implements InventoryItemRepository {
    final private Map<Long, InventoryItem> inventoryItemMap = new HashMap<>();
    private long inventoryItemId = 1;

    @Override
    public void add(InventoryItem inventoryItem) {
        inventoryItem.setId(inventoryItemId++);
        inventoryItemMap.put(inventoryItem.getId(), inventoryItem);
    }

    @Override
    public InventoryItem update(InventoryItem inventoryItem) {
        return Optional.ofNullable(inventoryItemMap.replace(inventoryItem.getId(), inventoryItem)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public InventoryItem delete(Long id) {
        return Optional.ofNullable(inventoryItemMap.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public InventoryItem find(Long id) {
        return Optional.ofNullable(inventoryItemMap.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<InventoryItem> findAll() {
        return inventoryItemMap.values().stream().collect(Collectors.toList());
    }
}
