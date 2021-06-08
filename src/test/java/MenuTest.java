import controllers.MenuController;
import controllers.ProductController;
import entities.Menu;
import entities.Product;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var menuController = ioc.<MenuController>getInstance("MenuController");
        var productController = ioc.<ProductController>getInstance("ProductController");

        List<Product> products = new ArrayList<>();
        products.add(productController.find(1L));
        products.add(productController.find(2L));

        Menu lunchMenu = new Menu("Lunch", products);

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing Menu structure-------------------------");
        System.out.println("Testing MenuController.add()");
        System.out.println("Adding Lunch Menu");
        menuController.add(lunchMenu);

        System.out.println("\nTesting MenuController.findAll() | must print true for the products validations");
        List<Menu> menus = menuController.findAll();
        System.out.println(menus.get(0).getName().equals(lunchMenu.getName()));

        System.out.println("\nTesting MenuController.find() | Finding the Lunch Menu Id = 1");
        System.out.println(menuController.find(1L).getName());

        System.out.println("\nTesting MenuController.delete() | Must throw EntityNotFoundException");
        Menu dinnerMenu = new Menu("Dinner Menu", products);
        menuController.add(dinnerMenu);
        menuController.delete(2L);
        try {
            menuController.find(2L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting MenuController.update() | Updating Lunch name to Lunch Menu");
        Menu menu = menuController.find(1L);
        System.out.println("Menu to update :");
        System.out.println(menu.getName());
        System.out.println("Menu updated :");
        menu.setName("Lunch Menu");
        Menu menuUpdated = menuController.update(menu);
        System.out.println(menuUpdated.getName());
    }
}
