package repositories.impl.map;

import entities.Chef;
import entities.EmployeeStatus;
import exceptions.EntityNotFoundException;
import repositories.ChefRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChefRepositoryImpl implements ChefRepository {

    final private Map<Long, Chef> chefs = new HashMap<>();
    private long id = 1;

    @Override
    public void add(Chef chef) {
        chef.setId(id++);
        chefs.put(chef.getId(), chef);
    }

    @Override
    public Chef update(Chef chef) {
        return Optional.ofNullable(chefs.replace(chef.getId(), chef)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Chef delete(Long id) {
        return Optional.ofNullable(chefs.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Chef find(Long id) {
        return Optional.ofNullable(chefs.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Chef> findAll() {
        return chefs.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Chef> findAvailableWaiters() {
        return chefs
                .values()
                .stream()
                .filter(w -> w.getStatus() == EmployeeStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
