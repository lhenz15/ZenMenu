package repositories;

import entities.Menu;

import java.util.List;

public interface MenuRepository extends GenericRepository<Menu, Long> {
    List<Menu> findAll();
}
