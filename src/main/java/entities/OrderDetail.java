package entities;

import java.util.List;

public class OrderDetail {
    private List<Product> products;
    private List<OrderTax> orderTaxes;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<OrderTax> getTaxes() {
        return orderTaxes;
    }

    public void setTaxes(List<OrderTax> orderTaxes) {
        this.orderTaxes = orderTaxes;
    }
}
