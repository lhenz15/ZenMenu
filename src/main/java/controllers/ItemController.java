package controllers;

import entities.Item;
import repositories.ItemRepository;

import java.util.List;

public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void add(Item item){
        itemRepository.add(item);
    }

    public Item update(Item item){
        return itemRepository.update(item);
    }

    public Item delete(Long id){
        return itemRepository.delete(id);
    }

    public Item find(Long id){
        return itemRepository.find(id);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }
}
