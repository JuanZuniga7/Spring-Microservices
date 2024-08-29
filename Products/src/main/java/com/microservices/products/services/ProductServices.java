package com.microservices.products.services;

import com.microservices.products.model.Product;
import com.microservices.products.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    private final IProductRepository productRepository;

    public ProductServices(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
