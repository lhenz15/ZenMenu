package repositories;

import entities.Product;

import java.util.List;

public interface ProductRepository extends IGenericRepository<Product, Long> {
    List<Product> findAll();
}
