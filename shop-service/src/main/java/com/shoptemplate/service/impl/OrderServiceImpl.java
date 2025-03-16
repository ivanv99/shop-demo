package com.shoptemplate.service.impl;

import com.shoptemplate.model.Order;
import com.shoptemplate.repositories.OrderRepository;
import com.shoptemplate.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
