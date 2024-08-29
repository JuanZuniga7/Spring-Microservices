package com.microservices.orders.repository;

import com.microservices.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM Order WHERE order_id = ?1", nativeQuery = true)
    Order findByOrderId(Long orderId);
}
