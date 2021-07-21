package repositories;

import entities.Order;
import entities.OrderStatus;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order, Long> {
    List<Order> findAll();

    List<Order> findOrdersByStatus(OrderStatus orderStatus);
}
