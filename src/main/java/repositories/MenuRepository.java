package repositories;

import entities.Menu;

import java.util.List;

public interface MenuRepository extends IGenericRepository<Menu, Long> {
    List<Menu> findAll();
}
