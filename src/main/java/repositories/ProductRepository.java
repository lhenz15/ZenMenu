package repositories;

import entities.Product;

import java.util.List;

public interface ProductRepository extends GenericRepository<Product, Long> {
    List<Product> findAll();
}
