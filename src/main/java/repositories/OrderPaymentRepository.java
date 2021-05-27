package repositories;

import entities.OrderPayment;

import java.util.List;

public interface OrderPaymentRepository extends GenericRepository<OrderPayment, Long> {
    List<OrderPayment> findAll();
}
