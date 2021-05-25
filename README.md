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

## repositories.impl.map.ItemRepositoryImpl
Class to implement the methods used to persist an Item.

## controllers.ItemController
Class used to manage and present an Item.

## repositories.impl.map.InventoryRepositoryImpl
Class to implement the methods used to persist an Inventory.

## repositories.impl.map.InventoryItemRepositoryImpl
Class to implement the methods used to persist an InventoryItem.

## repositories.MenuRepository
Class to implement the methods used to persist an InventoryItem.

## repositories.impl.map.ProductRepositoryImpl
Class to implement the methods used to persist an ProductRepository.

## repositories.OrderDetail
Class to implement the methods used to persist an OrderDetail.

## repositories.OrderPayment
Class to implement the methods used to persist and OrderPayment.

## repositories.Order
Class to implement the methods used to persist and Order.

## controllers.InventoryController
Class used to manage and present an Inventory.

## UML Class Diagram
![image](https://user-images.githubusercontent.com/12875895/119288688-0d662600-bc17-11eb-9c34-6e7a4baee359.png)
![image](https://user-images.githubusercontent.com/12875895/119436397-183dbb00-bcea-11eb-83c7-9952dd6716e4.png)

