package models;

public class StatusOrder {

    private entities.OrderStatus orderStatus;
    private Long orderId;

    public StatusOrder(entities.OrderStatus orderStatus, Long orderId) {
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public entities.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(entities.OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
