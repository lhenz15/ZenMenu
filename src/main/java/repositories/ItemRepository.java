package repositories;

import entities.Item;

import java.util.List;

public interface ItemRepository extends GenericRepository<Item, Long> {
    List<Item> findAll();
}
