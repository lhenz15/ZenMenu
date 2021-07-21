package repositories;

import entities.InventoryItem;
import entities.Item;

import java.util.List;

public interface InventoryItemRepository extends GenericRepository<InventoryItem, Long> {
    List<InventoryItem> findAll();

    boolean checkItemAvailability(Item item);
}
