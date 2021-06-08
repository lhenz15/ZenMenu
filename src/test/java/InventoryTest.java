import controllers.InventoryController;
import controllers.InventoryItemController;
import controllers.ItemController;
import entities.Inventory;
import entities.InventoryItem;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.List;

public class InventoryTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var inventoryController = ioc.<InventoryController>getInstance("InventoryController");
        var inventoryItemController = ioc.<InventoryItemController>getInstance("InventoryItemController");
        var itemController = ioc.<ItemController>getInstance("ItemController");

        Inventory inventory = new Inventory();
        inventory.setInventoryItems(inventoryItemController.findAll());

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing Inventory structure--------------------");
        System.out.println("Testing InventoryController.add()");
        System.out.println("Adding Inventory");
        inventoryController.add(inventory);

        System.out.println("\nTesting InventoryController.findAll() | must print true for the inventory validations");
        List<Inventory> inventories = inventoryController.findAll();
        System.out.println(inventories.get(0).getInventoryItems().get(0).getQuantity().equals(inventoryItemController.find(1L).getQuantity()));

        System.out.println("\nTesting InventoryController.find() | Finding the Inventory Id = 1, verifying inventory items size = 2");
        System.out.println(inventoryController.find(1L).getInventoryItems().size());

        System.out.println("\nTesting InventoryController.delete() | Must throw EntityNotFoundException");
        Inventory inventoryToDelete = new Inventory();
        inventoryController.add(inventoryToDelete);
        inventoryController.delete(2L);
        try {
            inventoryController.find(2L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting InventoryController.update() | Updating the inventory items on a Inventory");
        Inventory inventoryToUpdate = inventoryController.find(1L);
        System.out.println("Inventory to update :");
        System.out.println(inventoryToUpdate.getInventoryItems().size());
        System.out.println("Inventory updated :");
        InventoryItem orangeJuicyInventoryItem = new InventoryItem(inventory, itemController.find(5L), 10);
        InventoryItem waterBottleInventoryItem = new InventoryItem(inventory, itemController.find(3L), 10);
        inventoryItemController.add(orangeJuicyInventoryItem);
        inventoryItemController.add(waterBottleInventoryItem);
        inventoryToUpdate.setInventoryItems(inventoryItemController.findAll());
        Inventory inventoryUpdated = inventoryController.update(inventoryToUpdate);
        System.out.println(inventoryUpdated.getInventoryItems().size());
    }
}
