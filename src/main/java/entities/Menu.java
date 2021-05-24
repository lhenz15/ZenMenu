package entities;

import java.util.List;

public class Menu {
    private long id;
    private String name;
    private List<Product> products;

    public Menu() {
    }

    public Menu(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Menu(long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
