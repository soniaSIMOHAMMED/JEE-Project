package com.springboot.application.use_cases.order.controller;

import com.springboot.application.use_cases.order.exposition.OrderDto;
import com.springboot.application.use_cases.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(this.orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") long orderId) {
        return new ResponseEntity<>(this.orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    // TODO: add update request mapping

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable(name = "id") long orderId) {
        this.orderService.deleteOrder(orderId);
    }
}
