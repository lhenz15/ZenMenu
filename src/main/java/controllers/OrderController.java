package controllers;

import entities.Order;
import entities.OrderStatus;
import repositories.OrderRepository;

import java.util.List;

public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Order order){
        orderRepository.add(order);
    }

    public Order update(Order order){
        return orderRepository.update(order);
    }

    public Order delete(Long id){
        return orderRepository.delete(id);
    }

    public Order find(Long id){
        return orderRepository.find(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public List<Order> findOrdersByStatus(OrderStatus orderStatus){
        return orderRepository.findOrdersByStatus(orderStatus);
    }
}
