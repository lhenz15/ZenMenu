package utils;

import controllers.*;
import entities.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static IoC ioc = IoC.getInstance();

    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public static void init(){
        addProducts();
        addInventory();
        addMenu();
        addOrders();
        addWaiters();
    }

    public static void addProducts(){
        var productController = ioc.<ProductController>getInstance("ProductController");
        var itemController = ioc.<ItemController>getInstance("ItemController");

        Item bread = new Item("Bread");
        Item angusBurger = new Item("Angus Burger");
        Item cheese = new Item("Cheese");
        Item lettuce = new Item("Lettuce");
        Item tomato = new Item("Tomato");
        Item ketchup = new Item("Ketchup");
        Item bacon = new Item("Bacon");

        itemController.add(bread);
        itemController.add(angusBurger);
        itemController.add(cheese);
        itemController.add(lettuce);
        itemController.add(tomato);
        itemController.add(ketchup);
        itemController.add(bacon);

        List<Item> ingredients = new ArrayList<>();
        ingredients.add(bread);
        ingredients.add(angusBurger);
        ingredients.add(cheese);
        ingredients.add(lettuce);
        ingredients.add(tomato);
        ingredients.add(ketchup);

        Product cheeseBurger = new Product("Cheese Burger", 5.00, ProductType.BURGER, ingredients);

        ingredients.add(bacon);
        Product baconCheeseBurger = new Product("Bacon Cheese Burger", 6.00, ProductType.BURGER, ingredients);

        productController.add(cheeseBurger);
        productController.add(baconCheeseBurger);
    }

    public static void addInventory(){
        var inventoryController = ioc.<InventoryController>getInstance("InventoryController");
        var inventoryItemController = ioc.<InventoryItemController>getInstance("InventoryItemController");
        var itemController = ioc.<ItemController>getInstance("ItemController");

        Inventory inventory = new Inventory();
        List<InventoryItem> inventoryItems = new ArrayList<>();

        inventoryController.add(inventory);

        inventory = inventoryController.find(1L);

        inventoryItems.add(new InventoryItem(inventory, itemController.find(1L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(2L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(3L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(4L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(5L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(6L), 50));
        inventoryItems.add(new InventoryItem(inventory, itemController.find(7L), 0));

        for (InventoryItem inventoryItem : inventoryItems) {
            inventoryItemController.add(inventoryItem);
        }

        inventory.setInventoryItems(inventoryItemController.findAll());

        inventoryController.update(inventory);

    }

    public static void addMenu(){
        var menuController = ioc.<MenuController>getInstance("MenuController");
        var productController = ioc.<ProductController>getInstance("ProductController");

        List<Product> products = new ArrayList<>();
        products.add(productController.find(1L));
        products.add(productController.find(2L));

        Menu lunchMenu = new Menu("Lunch Menu", products);

        menuController.add(lunchMenu);
    }

    public static void addOrders(){
        var orderController = ioc.<OrderController>getInstance("OrderController");
        var orderDetailController = ioc.<OrderDetailController>getInstance("OrderDetailController");
        var productController = ioc.<ProductController>getInstance("ProductController");

        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("UTC-4"));

        List<Order> orders = new ArrayList<>();
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(productController.find(2L));

        orderDetails.add(new OrderDetail(productController.findAll(), null));
        orderDetails.add(new OrderDetail(productController.findAll(), null));
        orderDetails.add(new OrderDetail(productController.findAll(), null));
        orderDetails.add(new OrderDetail(products, null));
        orderDetails.add(new OrderDetail(products, null));
        orderDetails.add(new OrderDetail(products, null));

        for (OrderDetail orderDetail : orderDetails) {
            orderDetailController.add(orderDetail);
        }

        orders.add(new Order(date, null, orderDetailController.find(1L), "Luis", null));
        orders.add(new Order(date, null, orderDetailController.find(2L), "Eduardo", null));
        orders.add(new Order(date, null, orderDetailController.find(3L), "Luigi", null));
        orders.add(new Order(date, null, orderDetailController.find(4L), "Reynold", null));
        orders.add(new Order(date, null, orderDetailController.find(5L), "Elido", null));
        orders.add(new Order(date, null, orderDetailController.find(6L), "Arismendy", null));

        for (Order order : orders) {
            orderController.add(order);
        }
    }

    public static void addWaiters(){
        var waiterController = ioc.<WaiterController>getInstance("WaiterController");

        waiterController.add(new Waiter("Goku", EmployeeStatus.AVAILABLE));
        waiterController.add(new Waiter("Vegeta", EmployeeStatus.AVAILABLE));
    }
}
