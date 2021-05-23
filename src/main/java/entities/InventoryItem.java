package entities;

public class InventoryItem {
    private long id;
    private Inventory inventory;
    private Item item;
    private Integer quantity;

    public InventoryItem() {
    }

    public InventoryItem(Inventory inventory, Item item, Integer quantity) {
        this.inventory = inventory;
        this.item = item;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
