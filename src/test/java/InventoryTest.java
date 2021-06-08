import controllers.InventoryController;
import entities.Inventory;
import entities.InventoryItem;
import entities.Item;
import exceptions.EntityNotFoundException;
import utils.IoC;

import java.util.ArrayList;
import java.util.List;

public class InventoryTest {

    public static void main(String[] args) {
        IoC ioc = IoC.getInstance();

        var inventoryController = ioc.<InventoryController>getInstance("InventoryController");

        Inventory inventory = new Inventory();

        Item chair = new Item("Chair");
        Item table = new Item("Table");
        Item waterBottle = new Item("Water Bottle");

        InventoryItem chairInventoryItem = new InventoryItem(inventory, chair, 10);
        InventoryItem tableInventoryItem = new InventoryItem(inventory, table, 5);
        InventoryItem waterBottleInventoryItem = new InventoryItem(inventory, waterBottle, 50);

        List<InventoryItem> inventoryItems = new ArrayList<>();
        inventoryItems.add(chairInventoryItem);
        inventoryItems.add(tableInventoryItem);

        inventory.setInventoryItems(inventoryItems);

        System.out.println("Testing InventoryController.add()");
        System.out.println("Adding Inventory");
        inventoryController.add(inventory);

        System.out.println("\nTesting InventoryController.findAll() | must print true for the inventory validations");
        List<Inventory> inventories = inventoryController.findAll();
        System.out.println(inventories.get(0).getInventoryItems().get(0).getQuantity().equals(chairInventoryItem.getQuantity()));

        System.out.println("\nTesting InventoryController.find() | Finding the Inventory Id = 1, verifying inventory items size = 2");
        System.out.println(inventoryController.find(1L).getInventoryItems().size());

        System.out.println("\nTesting InventoryController.update() | Updating the inventory items on a Inventory");
        Inventory inventoryToUpdate = inventoryController.find(1L);
        List<InventoryItem> inventoryItemsToUpdate = inventoryToUpdate.getInventoryItems();
        System.out.println("Inventory to update :");
        System.out.println(inventoryToUpdate.getInventoryItems().size());
        System.out.println("Inventory updated :");
        inventoryItemsToUpdate.add(waterBottleInventoryItem);
        Inventory inventoryUpdated = inventoryController.update(inventoryToUpdate);
        System.out.println(inventoryUpdated.getInventoryItems().size());

        System.out.println("\nTesting InventoryController.delete() | Must throw EntityNotFoundException");
        inventoryController.delete(1L);
        try {
            inventoryController.find(1L);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
