package com.microservices.products.repository;

import com.microservices.products.model.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT * FROM Products WHERE name = ?1")
    User findByName(String name);
}
