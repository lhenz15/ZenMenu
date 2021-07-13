package managers;

import entities.Order;
import models.StatusOrder;

public class OrderQueueManager {

    private StatusManager<StatusOrder> statusManager;

    public OrderQueueManager() {
        statusManager = StatusManagerFactory.build(Order.class);
    }

    public boolean enqueue(String status, StatusOrder statusOrder){
        return statusManager.enqueue(status, statusOrder);
    }

    public StatusOrder dequeue(String status){
        return statusManager.dequeue(status);
    }
}
