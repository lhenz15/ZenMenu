package controllers;

import entities.Waiter;
import repositories.WaiterRepository;

import java.util.List;

public class WaiterController {

    private WaiterRepository waiterRepository;

    public WaiterController(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    public void add(Waiter waiter) {
        waiterRepository.add(waiter);
    }

    public Waiter update(Waiter waiter) {
        return waiterRepository.update(waiter);
    }

    public Waiter delete(Long id) {
        return waiterRepository.delete(id);
    }

    public Waiter find(Long id) {
        return waiterRepository.find(id);
    }

    public List<Waiter> findAll() {
        return waiterRepository.findAll();
    }

    public List<Waiter> findAvailableWaiters() {
        return waiterRepository.findAvailableWaiters();
    }
}
