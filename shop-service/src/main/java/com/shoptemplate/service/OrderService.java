package com.shoptemplate.service;

import com.shoptemplate.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(int id);

    void createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
