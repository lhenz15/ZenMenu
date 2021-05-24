package entities;

public abstract class OrderPayment {
    private long id;
    private double amount;

    public OrderPayment() {
    }

    public OrderPayment(double amount) {
        this.amount = amount;
    }

    public OrderPayment(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
