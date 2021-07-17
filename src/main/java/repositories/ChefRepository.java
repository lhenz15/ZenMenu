package repositories;

import entities.Chef;

import java.util.List;

public interface ChefRepository extends EmployeeRepository<Chef>{
    List<Chef> findAvailableWaiters();
}
