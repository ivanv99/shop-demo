package com.ivanvelev.repositories;

import com.ivanvelev.models.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();

    Order getOrderById(int id);

    void createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
