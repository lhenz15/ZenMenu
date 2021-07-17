package repositories;

import entities.Employee;

import java.util.List;

public interface EmployeeRepository<T extends Employee> extends GenericRepository<T, Long>{
    List<T> findAll();
}
