package repositories;

import entities.Order;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderRepository implements IGenericRepository<Order, Long>{

    final private Map<Long, Order> orders = new HashMap<>();
    private long orderId = 1;

    @Override
    public void add(Order order) {
        order.setId(orderId++);
        orders.put(order.getId(), order);
    }

    @Override
    public Order update(Order order) {
        return Optional.ofNullable(orders.replace(order.getId(), order)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Order delete(Long id) {
        return Optional.ofNullable(orders.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Order find(Long id) {
        return Optional.ofNullable(orders.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return orders.values().stream().collect(Collectors.toList());
    }
}
