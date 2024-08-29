package com.microservices.orders.services;

import com.microservices.orders.model.Order;
import com.microservices.orders.repository.IOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
