package com.springboot.application.use_cases.order.service;

import com.springboot.application.use_cases.order.domain.Order;
import com.springboot.application.use_cases.order.exposition.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(long orderId);
    List<OrderDto> getAllOrders();
    void deleteOrder(long orderId);
}
