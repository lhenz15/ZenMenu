package repositories;

import entities.Item;

import java.util.List;

public interface ItemRepository extends IGenericRepository<Item, Long> {
    List<Item> findAll();
}
