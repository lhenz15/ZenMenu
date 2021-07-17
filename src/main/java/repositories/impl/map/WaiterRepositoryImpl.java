package repositories.impl.map;

import entities.EmployeeStatus;
import entities.Waiter;
import exceptions.EntityNotFoundException;
import repositories.WaiterRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WaiterRepositoryImpl implements WaiterRepository {

    final private Map<Long, Waiter> waiters = new HashMap<>();
    private long id = 1;

    @Override
    public void add(Waiter waiter) {
        waiter.setId(id++);
        waiters.put(waiter.getId(), (Waiter) waiter);
    }

    @Override
    public Waiter update(Waiter waiter) {
        return Optional.ofNullable(waiters.replace(waiter.getId(), waiter)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Waiter delete(Long id) {
        return Optional.ofNullable(waiters.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Waiter find(Long id) {
        return Optional.ofNullable(waiters.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Waiter> findAll() {
        return waiters.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Waiter> findAvailableWaiters() {
        return waiters
                .values()
                .stream()
                .filter(w -> w.getStatus() == EmployeeStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
