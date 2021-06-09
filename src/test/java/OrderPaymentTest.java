import controllers.MenuController;
import controllers.OrderPaymentController;
import controllers.ProductController;
import entities.Menu;
import entities.OrderPayment;
import entities.Product;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.ArrayList;
import java.util.List;

public class OrderPaymentTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var orderPaymentController = ioc.<OrderPaymentController>getInstance("OrderPaymentController");

        OrderPayment anOrderPayment = new OrderPayment(100.00);
        OrderPayment anotherOrderPayment = new OrderPayment(50.00);

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing OrderPayment structure-----------------");
        System.out.println("Testing OrderPaymentController.add()");
        System.out.println("Adding an OrderPayment");
        orderPaymentController.add(anOrderPayment);
        System.out.println("Adding another OrderPayment");
        orderPaymentController.add(anotherOrderPayment);

        System.out.println("\nTesting OrderPaymentController.findAll() | must print true for the products validations");
        List<OrderPayment> orderPayments = orderPaymentController.findAll();
        System.out.println(orderPayments.get(0).getAmount() == anOrderPayment.getAmount());
        System.out.println(orderPayments.get(1).getAmount() == anotherOrderPayment.getAmount());

        System.out.println("\nTesting OrderPaymentController.find() | Finding Order Payment amount Id = 1");
        System.out.println(orderPaymentController.find(1L).getAmount());

        System.out.println("\nTesting OrderPaymentController.delete() | Must throw EntityNotFoundException");
        orderPaymentController.delete(2L);
        try {
            orderPaymentController.find(2L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting OrderPaymentController.update() | Updating Order Payment amount from 100.00 to 99.99");
        OrderPayment orderPayment = orderPaymentController.find(1L);
        System.out.println("Order Payment amount to update :");
        System.out.println(orderPayment.getAmount());
        System.out.println("Order Payment amount updated :");
        orderPayment.setAmount(99.99);
        OrderPayment orderPaymentUpdated = orderPaymentController.update(orderPayment);
        System.out.println(orderPaymentUpdated.getAmount());
    }
}
