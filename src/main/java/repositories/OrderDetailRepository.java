package repositories;

import entities.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends GenericRepository<OrderDetail, Long> {
    List<OrderDetail> findAll();
}
