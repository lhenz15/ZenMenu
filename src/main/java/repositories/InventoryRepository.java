package repositories;

import entities.Inventory;

import java.util.List;

public interface InventoryRepository extends GenericRepository<Inventory, Long> {
    List<Inventory> findAll();
}
