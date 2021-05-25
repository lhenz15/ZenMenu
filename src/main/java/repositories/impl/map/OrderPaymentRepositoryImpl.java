package repositories.impl.map;

import entities.OrderPayment;
import repositories.OrderPaymentRepository;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderPaymentRepositoryImpl implements OrderPaymentRepository {

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
    public List<OrderPayment> findAll() {
        return orderPayments.values().stream().collect(Collectors.toList());
    }
}
