import controllers.ItemController;
import controllers.ProductController;
import entities.*;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var productController = ioc.<ProductController>getInstance("ProductController");
        var itemController = ioc.<ItemController>getInstance("ItemController");

        Item bread = new Item("Bread");
        itemController.add(bread);
        Item angusBurger = new Item("Angus Burger");
        itemController.add(angusBurger);
        Item cheese = new Item("Cheese");
        itemController.add(cheese);
        Item lettuce = new Item("Lettuce");
        itemController.add(lettuce);
        Item tomato = new Item("Tomato");
        itemController.add(tomato);
        Item ketchup = new Item("Ketchup");
        itemController.add(ketchup);
        Item bacon = new Item("Bacon");
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

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing Product structure----------------------");
        System.out.println("Testing ProductController.add()");
        System.out.println("Adding Cheese Burger Product");
        productController.add(cheeseBurger);
        System.out.println("Adding Bacon Cheese Burger Product");
        productController.add(baconCheeseBurger);

        System.out.println("\nTesting ProductController.findAll() | must print true for the products validations");
        List<Product> products = productController.findAll();
        System.out.println(products.get(0).getName().equals(cheeseBurger.getName()));
        System.out.println(products.get(1).getName().equals(baconCheeseBurger.getName()));

        System.out.println("\nTesting ProductController.find() | Finding the Cheese Burger Product Id = 1");
        System.out.println(productController.find(1L).getName());

        System.out.println("\nTesting ProductController.delete() | Must throw EntityNotFoundException");
        Product productToDelete = new Product("Product To Delete", 6.00, ProductType.PASTA, null);
        productController.add(productToDelete);
        productController.delete(3L);
        try {
            productController.find(3L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting ProductController.update() | Updating Cheese Burger Product price from 5 to 4.5");
        Product productToUpdate = productController.find(1L);
        System.out.println("Item to update :");
        System.out.println(productToUpdate.getName() + " | " + productToUpdate.getPrice());
        System.out.println("Item updated :");
        productToUpdate.setPrice(4.5);
        Product productUpdated = productController.update(productToUpdate);
        System.out.println(productUpdated.getName() + " | " + productUpdated.getPrice());
    }
}
