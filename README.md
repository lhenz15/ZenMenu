# ZenMenu

## entities.Item
The class to represent the raw materials and the utensils used in the restaurant.

## entities.Inventory
Class used to manage to items in stock.

## entities.InventoryItem
Class used to manage the relation of an Item and an Inventory.

## entities.Product
Class used to represent dishes, desserts, drinks and other specialties.

## entities.ProductType
Enum to represent the types used in the product class.

## entities.Menu
Class to represent the  of products in stock.

## entities.Order
Class to represent the products consumed by the customers.

## entities.OrderPayment
Abstract class to represent the amount to pay on an order.

## entities.OrderTax
Enum to represent the different orderTaxes on an order.

## entities.OrderDetail
Class to represent the products and the orderTaxes presents in an order.

## entities.OrderStatus
Enum to represent the condition of an order.

## repositories.IGenericRepository
Interface to define the generic methods that need to be presents on a repository.

## repositories.ItemRepository
Class to implement the methods used to persist an Item.

## controllers.ItemController
Class used to manage and present an Item.

## repositories.InventoryRepository
Class to implement the methods used to persist an Inventory.

## repositories.InventoryItemRepository
Class to implement the methods used to persist an InventoryItem.

## UML Class Diagram
![image](https://user-images.githubusercontent.com/12875895/119280635-41821c80-bc00-11eb-8f80-74cbd675790e.png)
