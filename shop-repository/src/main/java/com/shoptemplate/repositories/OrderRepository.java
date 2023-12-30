package com.shoptemplate.repositories;

import com.shoptemplate.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}