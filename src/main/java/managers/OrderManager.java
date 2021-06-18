package managers;

import entities.Order;
import entities.OrderStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager {

    private Map<OrderStatus, BlockingQueue> orderQueueMap = new HashMap<>();
    private Map<Long, Order> preparingOrders = new HashMap<>();

    public OrderManager() {
        orderQueueMap.put(OrderStatus.PENDING, new LinkedBlockingQueue<Order>());
        orderQueueMap.put(OrderStatus.COMPLETED, new LinkedBlockingQueue<Order>());
    }

    public boolean addToQueue(Order order){
        return orderQueueMap.get(order.getStatus()).offer(order);
    }

    public Order getOrder(OrderStatus orderStatus){
        return (Order) orderQueueMap.get(orderStatus).poll();
    }

    public void prepareOrder(Order order){
        preparingOrders.put(order.getId(), order);
    }

    public Order completeOrder(Long id){
        return preparingOrders.remove(id);
    }
}
