package com.shoptemplate.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    @NotBlank(message = "Name is required and cannot be blank.")
    private String name;

    @Positive(message = "Price must be greater than zero.")
    private double price;

}
