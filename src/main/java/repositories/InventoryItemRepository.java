package repositories;

import entities.InventoryItem;

import java.util.List;

public interface InventoryItemRepository extends GenericRepository<InventoryItem, Long> {
    List<InventoryItem> findAll();
}
