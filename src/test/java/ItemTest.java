import controllers.ItemController;
import entities.Item;
import exceptions.EntityNotFoundException;
import repositories.ItemRepository;
import utils.IoC;

import java.util.List;

public class ItemTest {

    public static void main(String[] args) {

        IoC ioc = IoC.getInstance();

        var itemController = ioc.<ItemController>getInstance("ItemController");

        Item chair = new Item("Chair");
        Item table = new Item("Table");
        Item waterBottle = new Item("Water Bottle");

        System.out.println(ItemRepository.class.getName());

        System.out.println("Testing ItemController.add()");
        System.out.println("Adding Chair Item");
        itemController.add(chair);
        System.out.println("Adding Table Item");
        itemController.add(table);
        System.out.println("Adding Water Bottle Item");
        itemController.add(waterBottle);

        System.out.println("\nTesting ItemController.findAll() | must print true for the items validations");
        List<Item> items = itemController.findAll();
        System.out.println(items.get(0).getName().equals(chair.getName()));
        System.out.println(items.get(1).getName().equals(table.getName()));
        System.out.println(items.get(2).getName().equals(waterBottle.getName()));

        System.out.println("\nTesting ItemController.find() | Finding the Table Item Id = 2");
        System.out.println(itemController.find(2L).getName());

        System.out.println("\nTesting ItemController.delete() | Must throw EntityNotFoundException");
        itemController.delete(3L);
        try {
            itemController.find(3L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting ItemController.update() | Updating Chair Item to Large Chair");
        Item itemToUpdate = itemController.find(1L);
        System.out.println("Item to update :");
        System.out.println(itemToUpdate.getName());
        System.out.println("Item updated :");
        itemToUpdate.setName("Large Chair");
        System.out.println(itemController.update(itemToUpdate).getName());
    }
}
