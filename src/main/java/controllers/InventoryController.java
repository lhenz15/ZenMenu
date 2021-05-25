package controllers;

import entities.Inventory;
import repositories.InventoryRepository;

import java.util.List;

public class InventoryController {

    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void add(Inventory inventory){
        inventoryRepository.add(inventory);
    }

    public Inventory update(Inventory inventory){
        return inventoryRepository.update(inventory);
    }

    public Inventory delete(Long id){
        return inventoryRepository.delete(id);
    }

    public Inventory find(Long id){
        return inventoryRepository.find(id);
    }

    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }
}
