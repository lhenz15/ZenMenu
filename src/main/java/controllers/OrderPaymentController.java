package controllers;

import entities.OrderPayment;
import repositories.OrderPaymentRepository;

import java.util.List;

public class OrderPaymentController {

    private OrderPaymentRepository orderPaymentRepository;

    public OrderPaymentController(OrderPaymentRepository orderPaymentRepository) {
        this.orderPaymentRepository = orderPaymentRepository;
    }

    public void add(OrderPayment orderPayment){
        orderPaymentRepository.add(orderPayment);
    }

    public OrderPayment update(OrderPayment orderPayment){
        return orderPaymentRepository.update(orderPayment);
    }

    public OrderPayment delete(Long id){
        return orderPaymentRepository.delete(id);
    }

    public OrderPayment find(Long id){
        return orderPaymentRepository.find(id);
    }

    public List<OrderPayment> findAll(){
        return orderPaymentRepository.findAll();
    }
}
