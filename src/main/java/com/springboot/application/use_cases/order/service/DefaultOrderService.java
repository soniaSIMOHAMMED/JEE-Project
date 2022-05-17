package com.springboot.application.use_cases.order.service;

import com.springboot.application.use_cases.order.domain.Order;
import com.springboot.application.use_cases.order.exposition.OrderDto;
import com.springboot.application.use_cases.order.infrastructure.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultOrderService implements OrderService{

    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    public DefaultOrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

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
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        return null; //TODO: implémentation de la méthode updateOrder après la liaison entre order et product
    }

    @Override
    public void deleteOrder(long orderId) {
        Order order = this.orderRepository.findById(orderId).orElseThrow();
        this.orderRepository.delete(order);
    }

    private OrderDto mapToDto(Order order) { return modelMapper.map(order,OrderDto.class); }

    private Order mapToEntity(OrderDto orderDto) { return modelMapper.map(orderDto, Order.class); }
}
