import controllers.OrderController;
import controllers.OrderDetailController;
import controllers.OrderPaymentController;
import entities.Order;
import entities.OrderDetail;
import entities.OrderPayment;
import entities.OrderStatus;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class OrderTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var orderController = ioc.<OrderController>getInstance("OrderController");
        var orderDetailController = ioc.<OrderDetailController>getInstance("OrderDetailController");
        var orderPaymentController = ioc.<OrderPaymentController>getInstance("OrderPaymentController");

        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("UTC-4"));
        OrderDetail orderDetail = orderDetailController.find(1L);
        OrderPayment orderPayment = orderPaymentController.find(1L);

        Order luisOrder = new Order(date, OrderStatus.PENDING, orderDetail, "Luis", orderPayment);
        Order eduardoOrder = new Order(date, OrderStatus.PENDING, orderDetail, "Eduardo", orderPayment);

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing Order structure------------------------");
        System.out.println("Testing OrderController.add()");
        System.out.println("Adding Luis's Order");
        orderController.add(luisOrder);
        System.out.println("Adding Eduardo's Order");
        orderController.add(eduardoOrder);

        System.out.println("\nTesting OrderController.findAll() | must print true for the products validations");
        List<Order> orders = orderController.findAll();
        System.out.println(orders.get(0).getCustomer().equals(luisOrder.getCustomer()));
        System.out.println(orders.get(1).getCustomer().equals(eduardoOrder.getCustomer()));

        System.out.println("\nTesting OrderController.find() | Finding Luis's Order status Id = 1");
        System.out.println(orderController.find(1L).getStatus());

        System.out.println("\nTesting OrderController.delete() | Must throw EntityNotFoundException");
        orderController.delete(2L);
        try {
            orderController.find(2L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting OrderController.update() | Updating Order customer from Luis to Luis Eduardo");
        Order order = orderController.find(1L);
        System.out.println("Order customer to update :");
        System.out.println(order.getCustomer());
        System.out.println("Order customer updated :");
        order.setCustomer("Luis Eduardo");
        Order orderUpdated = orderController.update(order);
        System.out.println(orderUpdated.getCustomer());
    }
}
