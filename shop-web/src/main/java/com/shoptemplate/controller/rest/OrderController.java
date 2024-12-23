package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Order;
import com.shoptemplate.model.dto.OrderDto;
import com.shoptemplate.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders()
                .stream()
                .map(modelMapper::convertToDto)
                .toList();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(order -> ResponseEntity.ok(modelMapper.convertToDto(order)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        Order order = modelMapper.convertFromDto(orderDto);
        orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convertToDto(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        return orderService.getOrderById(id)
                .map(existingOrder -> {
                    existingOrder = modelMapper.convertFromDto(orderDto);
                    orderService.updateOrder(existingOrder);
                    return ResponseEntity.ok(modelMapper.convertToDto(existingOrder));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(order -> {
                    orderService.deleteOrder(order);
                    return ResponseEntity.ok(modelMapper.convertToDto(order));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
