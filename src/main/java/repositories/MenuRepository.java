package repositories;

import entities.Menu;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuRepository implements IGenericRepository<Menu, Long>{

    final private Map<Long, Menu> menus = new HashMap<>();
    private int menuId = 1;

    @Override
    public void add(Menu menu) {
        menu.setId(menuId++);
        menus.put(menu.getId(), menu);
    }

    @Override
    public Menu update(Menu menu) {
        return Optional.ofNullable(menus.replace(menu.getId(), menu)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Menu delete(Long id) {
        return Optional.ofNullable(menus.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Menu find(Long id) {
        return Optional.ofNullable(menus.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Menu> findAll() {
        return menus.values().stream().collect(Collectors.toList());
    }
}
