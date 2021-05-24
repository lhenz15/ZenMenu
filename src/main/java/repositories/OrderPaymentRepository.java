package repositories;

import entities.OrderPayment;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderPaymentRepository implements IGenericRepository<OrderPayment, Long> {

    final private Map<Long, OrderPayment> orderPayments = new HashMap<>();
    private long orderPaymentId = 1;

    @Override
    public void add(OrderPayment orderPayment) {
        orderPayment.setId(orderPaymentId++);
        orderPayments.put(orderPayment.getId(), orderPayment);
    }

    @Override
    public OrderPayment update(OrderPayment orderPayment) {
        return Optional.ofNullable(orderPayments.replace(orderPayment.getId(), orderPayment)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public OrderPayment delete(Long id) {
        return Optional.ofNullable(orderPayments.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public OrderPayment find(Long id) {
        return Optional.ofNullable(orderPayments.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Iterable<OrderPayment> findAll() {
        return orderPayments.values().stream().collect(Collectors.toList());
    }
}
