package com.springboot.application.use_cases.order.service;

import com.springboot.application.use_cases.order.domain.Order;
import com.springboot.application.use_cases.order.exposition.OrderDto;
import com.springboot.application.use_cases.order.infrastructure.OrderRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultOrderService implements OrderService{

    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        Order newOrder = this.orderRepository.save(order);
        return mapToDto(newOrder);
    }

    @Override
    public OrderDto getOrderById(long orderId) {
        Order order = this.orderRepository.getById(orderId);
        return mapToDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = this.orderRepository.findAll();
        return orders.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(long orderId) {
        Order order = this.orderRepository.getById(orderId);
        this.orderRepository.delete(order);
    }

    private OrderDto mapToDto(Order order) { return modelMapper.map(order,OrderDto.class); }

    private Order mapToEntity(OrderDto orderDto) { return modelMapper.map(orderDto, Order.class); }
}
