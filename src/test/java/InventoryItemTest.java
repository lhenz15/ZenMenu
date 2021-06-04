import controllers.InventoryItemController;
import controllers.ItemController;
import entities.Inventory;
import entities.InventoryItem;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.List;

public class InventoryItemTest {

    public static void test() {
        IoC ioc = IoC.getInstance();

        var inventoryItemController = ioc.<InventoryItemController>getInstance("InventoryItemController");
        var itemController = ioc.<ItemController>getInstance("ItemController");

        Inventory inventory = new Inventory();

        InventoryItem chairInventoryItem = new InventoryItem(inventory, itemController.find(1L), 10);
        InventoryItem tableInventoryItem = new InventoryItem(inventory, itemController.find(2L), 5);
        InventoryItem waterBottleInventoryItem = new InventoryItem(inventory, itemController.find(3L), 50);

        System.out.print("\n\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------Testing InventoryItem structure----------------");
        System.out.println("Testing InventoryItemController.add()");
        System.out.println("Adding Chair Inventory Item");
        inventoryItemController.add(chairInventoryItem);
        System.out.println("Adding Table Inventory Item");
        inventoryItemController.add(tableInventoryItem);
        System.out.println("Adding Water Bottle Inventory Item");
        inventoryItemController.add(waterBottleInventoryItem);

        System.out.println("\nTesting InventoryItemController.findAll() | must print true for the inventory items validations");
        List<InventoryItem> inventoryItems = inventoryItemController.findAll();
        System.out.println(inventoryItems.get(0).getQuantity().equals(chairInventoryItem.getQuantity()));
        System.out.println(inventoryItems.get(1).getQuantity().equals(tableInventoryItem.getQuantity()));
        System.out.println(inventoryItems.get(2).getQuantity().equals(waterBottleInventoryItem.getQuantity()));

        System.out.println("\nTesting InventoryItemController.find() | Finding the Table Item Id = 2");
        System.out.println(inventoryItemController.find(2L).getItem().getName());

        System.out.println("\nTesting InventoryItemController.delete() | Must throw EntityNotFoundException");
        inventoryItemController.delete(3L);
        try {
            inventoryItemController.find(3L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting InventoryItemController.update() | Updating Chair Item to Large Chair");
        InventoryItem inventoryItemToUpdate = inventoryItemController.find(1L);
        System.out.println("Item to update :");
        System.out.println(inventoryItemToUpdate.getItem().getName() + " " + inventoryItemToUpdate.getQuantity());
        System.out.println("Item updated :");
        inventoryItemToUpdate.setQuantity(15);
        InventoryItem inventoryItemUpdated = inventoryItemController.update(inventoryItemToUpdate);
        System.out.println(inventoryItemUpdated.getItem().getName() + " " + inventoryItemUpdated.getQuantity());
    }
}
