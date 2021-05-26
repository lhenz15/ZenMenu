package controllers;



import entities.Menu;
import repositories.MenuRepository;

import java.util.List;

public class MenuController {

    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void add(Menu menu){
        menuRepository.add(menu);
    }

    public Menu update(Menu menu){
        return menuRepository.update(menu);
    }

    public Menu delete(Long id){
        return menuRepository.delete(id);
    }

    public Menu find(Long id){
        return menuRepository.find(id);
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }
}
