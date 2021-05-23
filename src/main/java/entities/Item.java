package entities;

public class Item {
    private long id;
    private String name;

    public Item() {
    }

    public Item(String name, double quantity) {
        this.name = name;
    }

    public Item(int id, String name, double quantity) {
        this.id = id;
        this.name = name;
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
}
