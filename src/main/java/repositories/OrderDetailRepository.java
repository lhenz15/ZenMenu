package repositories;

import entities.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends IGenericRepository<OrderDetail, Long> {
    List<OrderDetail> findAll();
}
