package entities;

import java.util.List;

public class OrderDetail {
    private long id;
    private List<Product> products;
    private List<OrderTax> orderTaxes;

    public OrderDetail() {
    }

    public OrderDetail(List<Product> products, List<OrderTax> orderTaxes) {
        this.products = products;
        this.orderTaxes = orderTaxes;
    }

    public OrderDetail(long id, List<Product> products, List<OrderTax> orderTaxes) {
        this.id = id;
        this.products = products;
        this.orderTaxes = orderTaxes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<OrderTax> getOrderTaxes() {
        return orderTaxes;
    }

    public void setOrderTaxes(List<OrderTax> orderTaxes) {
        this.orderTaxes = orderTaxes;
    }
}
