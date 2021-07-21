package core;

import controllers.InventoryItemController;
import controllers.OrderController;
import controllers.WaiterController;
import entities.*;
import managers.OrderQueueManager;
import models.StatusOrder;
import utils.IoC;
import utils.Utils;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KitchenSimulator {

    private static IoC ioc = IoC.getInstance();
    private static OrderQueueManager orderQueueManager = new OrderQueueManager();

    public static void main(String[] args) throws InterruptedException {
        Utils.init();

        KitchenSimulator kitchenSimulator = new KitchenSimulator();

        while (true) {
            kitchenSimulator.moveOrdersToPendingQueue();
            kitchenSimulator.executeWaiterJob();

            Thread.sleep(5000);
        }

    }

    public void moveOrdersToPendingQueue() {
        var orderController = ioc.<OrderController>getInstance("OrderController");

        List<Order> orders = orderController.findOrdersByStatus(null);

        if(orders.size() > 0) {
            for (Order order : orders) {
                System.out.println("Moving order " + order.getId() + " to PENDING queue.");

                order.setStatus(OrderStatus.PENDING);

                orderController.update(order);

                StatusOrder statusOrder = new StatusOrder(order.getStatus(), order.getId());
                orderQueueManager.enqueue(statusOrder.getOrderStatus().name(), statusOrder);
            }
        } else {
            System.out.println("All orders are processing.");
        }
    }

    public void executeWaiterJob() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        var waiterController = ioc.<WaiterController>getInstance("WaiterController");

        List<Waiter> availableWaiters = waiterController.findAvailableWaiters();

        if(availableWaiters.size() > 0) {
            System.out.println(availableWaiters.size()
                    + " waiters available.");
            for (Waiter waiter : availableWaiters) {
                StatusOrder statusOrder = orderQueueManager.dequeue(OrderStatus.PENDING.name());

                if (statusOrder != null) {
                    executorService.schedule(getWaiterTask(waiter, statusOrder), 0, TimeUnit.SECONDS);
                } else {
                    System.out.println("All orders have been verified.");
                    break;
                }
            }
        }else{
            System.out.println("All waiters are busy.");
        }
    }

    public Runnable getWaiterTask(Waiter waiter, StatusOrder statusOrder) {
        Runnable task = () -> {
            var orderController = ioc.<OrderController>getInstance("OrderController");

            changeWaiterStatus(waiter, EmployeeStatus.BUSY);

            Order order = orderController.find(statusOrder.getOrderId());

            System.out.println(waiter.getName()
                    + " is verifying "
                    + order.getCustomer()
                    + " order ID: "
                    + order.getId());

            try {
                Thread.sleep(2000 * waiter.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (checkIngredients(order.getOrderDetail().getProducts())){
                statusOrder.setOrderStatus(OrderStatus.CANCELLED);

                System.out.println("Order ID: " + order.getId() + " cancelled.");
            }
            else {
                statusOrder.setOrderStatus(OrderStatus.PREPARING);

                System.out.println("Order ID: " + order.getId() + " verified.");
            }

            orderQueueManager.enqueue(statusOrder.getOrderStatus().name(), statusOrder);

            changeWaiterStatus(waiter, EmployeeStatus.AVAILABLE);
        };

        return task;
    }

    private void changeWaiterStatus(Waiter waiter, EmployeeStatus employeeStatus){
        var waiterController = ioc.<WaiterController>getInstance("WaiterController");

        waiter.setStatus(employeeStatus);
        waiterController.update(waiter);
    }

    private boolean checkIngredients(List<Product> products){
        var inventoryItemController = ioc.<InventoryItemController>getInstance("InventoryItemController");

        boolean unavailableItem = false;

        for (Product product : products) {
            for (Item ingredient : product.getIngredients()) {
                if(!inventoryItemController.checkItemAvailability(ingredient)) {
                    unavailableItem = true;
                    break;
                }
            }

            if(unavailableItem)
                break;
        }

        return unavailableItem;
    }
}
