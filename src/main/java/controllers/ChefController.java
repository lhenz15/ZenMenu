package controllers;

import entities.Chef;
import repositories.ChefRepository;

import java.util.List;

public class ChefController {

    private ChefRepository chefRepository;

    public ChefController(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    public void add(Chef chef) {
        chefRepository.add(chef);
    }

    public Chef update(Chef chef) {
        return chefRepository.update(chef);
    }

    public Chef delete(Long id) {
        return chefRepository.delete(id);
    }

    public Chef find(Long id) {
        return chefRepository.find(id);
    }

    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    public List<Chef> findAvailableWaiters() {
        return chefRepository.findAvailableWaiters();
    }
}
