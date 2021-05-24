package repositories;

import entities.Product;
import utils.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepository implements IGenericRepository<Product, Long>{

    final private Map<Long, Product> products = new HashMap<>();
    private int productId = 1;

    @Override
    public void add(Product product) {
        product.setId(productId++);
        products.put(product.getId(), product);
    }

    @Override
    public Product update(Product product) {
        return Optional.ofNullable(products.replace(product.getId(), product)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product delete(Long id) {
        return Optional.ofNullable(products.remove(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product find(Long id) {
        return Optional.ofNullable(products.get(id)).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().collect(Collectors.toList());
    }
}
