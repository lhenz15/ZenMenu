package managers;

import entities.Order;
import entities.OrderStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager {

    private Map<OrderStatus, BlockingQueue> orderQueueMap = new HashMap<>();

    public OrderManager() {
        orderQueueMap.put(OrderStatus.PENDING, new LinkedBlockingQueue<Order>());
        orderQueueMap.put(OrderStatus.COMPLETED, new LinkedBlockingQueue<Order>());
        orderQueueMap.put(OrderStatus.CONFIRMED, new LinkedBlockingQueue<Order>());
        orderQueueMap.put(OrderStatus.PREPARING, new LinkedBlockingQueue<Order>());
        orderQueueMap.put(OrderStatus.CANCELLED, new LinkedBlockingQueue<Order>());
    }

    public boolean addToQueue(Order order){
        return orderQueueMap.get(order.getStatus()).offer(order);
    }

    public Order getOrder(OrderStatus orderStatus){
        return (Order) orderQueueMap.get(orderStatus).poll();
    }
}
