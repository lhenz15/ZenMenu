package controllers;

import entities.Product;
import repositories.ProductRepository;

import java.util.List;

public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product){
        productRepository.add(product);
    }

    public Product update(Product product){
        return productRepository.update(product);
    }

    public Product delete(Long id){
        return productRepository.delete(id);
    }

    public Product find(Long id){
        return productRepository.find(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
