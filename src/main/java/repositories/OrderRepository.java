package repositories;

import entities.Order;

import java.util.List;

public interface OrderRepository extends IGenericRepository<Order, Long>{
    List<Order> findAll();
}
