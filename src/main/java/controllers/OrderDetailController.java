package controllers;

import entities.OrderDetail;
import repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailController {

    private OrderDetailRepository orderDetailRepository;

    public OrderDetailController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public void add(OrderDetail orderDetail){
        orderDetailRepository.add(orderDetail);
    }

    public OrderDetail update(OrderDetail orderDetail){
        return orderDetailRepository.update(orderDetail);
    }

    public OrderDetail delete(Long id){
        return orderDetailRepository.delete(id);
    }

    public OrderDetail find(Long id){
        return orderDetailRepository.find(id);
    }

    public List<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }
}
