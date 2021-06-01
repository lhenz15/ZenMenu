import controllers.InventoryItemController;
import entities.Inventory;
import entities.InventoryItem;
import entities.Item;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.List;

public class InventoryItemTest {

    public static void main(String[] args) {
        IoC ioc = IoC.getInstance();

        var inventoryItemController = ioc.<InventoryItemController>getInstance("InventoryItemController");

        Inventory inventory = new Inventory();

        Item chair = new Item("Chair");
        Item table = new Item("Table");
        Item waterBottle = new Item("Water Bottle");

        InventoryItem chairInventoryItem = new InventoryItem(inventory, chair, 10);
        InventoryItem tableInventoryItem = new InventoryItem(inventory, table, 5);
        InventoryItem waterBottleInventoryItem = new InventoryItem(inventory, waterBottle, 50);

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

        System.out.println("\nTesting ItemController.find() | Finding the Table Item Id = 2");
        System.out.println(inventoryItemController.find(2L).getItem().getName());

        System.out.println("\nTesting ItemController.delete() | Must throw EntityNotFoundException");
        inventoryItemController.delete(3L);
        try {
            inventoryItemController.find(3L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTesting ItemController.update() | Updating Chair Item to Large Chair");
        InventoryItem inventoryItemToUpdate = inventoryItemController.find(1L);
        System.out.println("Item to update :");
        System.out.println(inventoryItemToUpdate.getItem().getName() + " " + inventoryItemToUpdate.getQuantity());
        System.out.println("Item updated :");
        inventoryItemToUpdate.setQuantity(15);
        InventoryItem inventoryItemUpdated = inventoryItemController.update(inventoryItemToUpdate);
        System.out.println(inventoryItemUpdated.getItem().getName() + " " + inventoryItemUpdated.getQuantity());
    }
}
