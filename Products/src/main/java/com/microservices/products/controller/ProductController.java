package com.microservices.products.controller;

import com.microservices.products.model.Product;
import com.microservices.products.services.ProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping("/products/create")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product response = productServices.saveProduct(product);
        return new ResponseEntity<Product>(response, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> response = productServices.getProducts();
        return new ResponseEntity<Iterable<Product>>(response, HttpStatus.OK);
    }
}
