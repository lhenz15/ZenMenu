package repositories;

import entities.InventoryItem;

import java.util.List;

public interface InventoryItemRepository extends IGenericRepository<InventoryItem, Long>{
    List<InventoryItem> findAll();
}
