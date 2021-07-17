package repositories;

import entities.Waiter;

import java.util.List;

public interface WaiterRepository extends EmployeeRepository<Waiter>{
    List<Waiter> findAvailableWaiters();
}
