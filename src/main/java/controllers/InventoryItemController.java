package controllers;

import entities.InventoryItem;
import repositories.InventoryItemRepository;

import java.util.List;

public class InventoryItemController {

    private InventoryItemRepository inventoryItemRepository;

    public InventoryItemController(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public void add(InventoryItem inventoryItem){
        inventoryItemRepository.add(inventoryItem);
    }

    public InventoryItem update(InventoryItem inventoryItem){
        return inventoryItemRepository.update(inventoryItem);
    }

    public InventoryItem delete(Long id){
        return inventoryItemRepository.delete(id);
    }

    public InventoryItem find(Long id){
        return inventoryItemRepository.find(id);
    }

    public List<InventoryItem> findAll(){
        return inventoryItemRepository.findAll();
    }
}
