package repositories;

import entities.OrderPayment;

import java.util.List;

public interface OrderPaymentRepository extends IGenericRepository<OrderPayment, Long> {
    List<OrderPayment> findAll();
}
