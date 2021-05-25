package repositories;

import entities.Inventory;

import java.util.List;

public interface InventoryRepository extends IGenericRepository<Inventory, Long> {
    List<Inventory> findAll();
}
