package com.microservices.orders.controller;

import com.microservices.orders.model.Order;
import com.microservices.orders.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/create")
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/order")
    public ResponseEntity<Order> getOrderById(@RequestParam(name = "order_id") Long id) {
        return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
    }
}
