package repositories;

import entities.Order;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order, Long> {
    List<Order> findAll();
}
