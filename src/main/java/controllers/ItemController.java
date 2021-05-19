package controllers;

import entities.Item;
import repositories.ItemRepository;

import java.util.List;

public class ItemController {

    private ItemRepository itemRepository;

    public ItemController() {
        this.itemRepository = new ItemRepository();
    }

    public void add(Item item){
        itemRepository.add(item);
    }

    public Item update(Item item){
        return itemRepository.update(item);
    }

    public Item delete(Integer id){
        return itemRepository.delete(id);
    }

    public Item find(Integer id){
        return itemRepository.find(id);
    }

    public List<Item> findAll(){
        return (List<Item>) itemRepository.findAll();
    }
}
