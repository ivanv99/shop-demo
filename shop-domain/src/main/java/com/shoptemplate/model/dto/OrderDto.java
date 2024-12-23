package com.shoptemplate.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @NotNull(message = "User ID is required.")
    @Positive(message = "User ID must be positive.")
    private Long user;

    @NotNull(message = "Address ID is required.")
    @Positive(message = "Address ID must be positive.")
    private Long address;

    @NotEmpty(message = "Order items are required.")
    private List<Long> orderItems;

    @NotNull(message = "Timestamp is required.")
    private LocalDateTime timestamp;
}
