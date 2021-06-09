import controllers.OrderDetailController;
import controllers.OrderPaymentController;
import controllers.ProductController;
import entities.OrderDetail;
import entities.OrderPayment;
import entities.OrderTax;
import entities.Product;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var orderDetailController = ioc.<OrderDetailController>getInstance("OrderDetailController");
        var productController = ioc.<ProductController>getInstance("ProductController");

        List<Product> products = productController.findAll();
        List<OrderTax> orderTaxes = new ArrayList<>();
        List<OrderTax> anotherOrderTaxesList = new ArrayList<>();

        orderTaxes.add(OrderTax.ITBIS);
        OrderDetail anOrderDetail = new OrderDetail(products, orderTaxes);

        anotherOrderTaxesList.add(OrderTax.ITBIS);
        anotherOrderTaxesList.add(OrderTax.SERVICE_COMMISION);
        OrderDetail anotherOrderDetail = new OrderDetail(products, anotherOrderTaxesList);

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing OrderDetail structure------------------");
        System.out.println("Testing OrderDetailController.add()");
        System.out.println("Adding an OrderDetail");
        orderDetailController.add(anOrderDetail);
        System.out.println("Adding another OrderDetail");
        orderDetailController.add(anotherOrderDetail);

        System.out.println("\nTesting OrderDetailController.findAll() | must print true for the products validations");
        List<OrderDetail> orderDetails = orderDetailController.findAll();
        System.out.println(orderDetails.get(0).getOrderTaxes().size() == 1);
        System.out.println(orderDetails.get(1).getOrderTaxes().size() == 2);

        System.out.println("\nTesting OrderDetailController.find() | Finding Order Detail taxes size Id = 1");
        System.out.println(orderDetailController.find(1L).getOrderTaxes().size());

        System.out.println("\nTesting OrderDetailController.delete() | Must throw EntityNotFoundException");
        orderDetailController.delete(2L);
        try {
            orderDetailController.find(2L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting OrderDetailController.update() | Updating Order Detail taxes size from 1 to 2");
        OrderDetail orderDetail = orderDetailController.find(1L);
        System.out.println("Order Detail size to update :");
        System.out.println(orderDetail.getOrderTaxes().size());
        System.out.println("Order Detail size updated :");
        orderDetail.setOrderTaxes(anotherOrderTaxesList);
        OrderDetail orderDetailUpdated = orderDetailController.update(orderDetail);
        System.out.println(orderDetailUpdated.getOrderTaxes().size());
    }
}
