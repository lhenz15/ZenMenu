package repositories;

import entities.OrderDetail;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderDetailRepository implements IGenericRepository<OrderDetail, Long>{

    final private Map<Long, OrderDetail> orderDetails = new HashMap<>();
    private long orderDetailId = 1;

    @Override
    public void add(OrderDetail orderDetail) {
        orderDetail.setId(orderDetailId++);
        orderDetails.put(orderDetail.getId(), orderDetail);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        return Optional.ofNullable(orderDetails.replace(orderDetail.getId(), orderDetail)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public OrderDetail delete(Long id) {
        return Optional.ofNullable(orderDetails.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public OrderDetail find(Long id) {
        return Optional.ofNullable(orderDetails.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetails.values().stream().collect(Collectors.toList());
    }
}
