package entities;

import java.util.List;

public class Inventory {
    private long id;
    private List<InventoryItem> inventoryItems;

    public Inventory() {
    }

    public Inventory(int id, List<InventoryItem> inventoryItems) {
        this.id = id;
        this.inventoryItems = inventoryItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
