package entities;

public class Item {
    private int id;
    private String name;
    private double quantity;

    public Item() {
    }

    public Item(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Item(int id, String name, double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
