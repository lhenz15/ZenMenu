package entities;

import java.time.ZonedDateTime;

public class Order {
    private long id;
    private ZonedDateTime date;
    private OrderStatus orderStatus;
    private OrderDetail orderDetail;
    private String customer;
    private OrderPayment orderPayment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return orderStatus;
    }

    public void setStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public OrderPayment getPayment() {
        return orderPayment;
    }

    public void setPayment(OrderPayment orderPayment) {
        this.orderPayment = orderPayment;
    }
}
