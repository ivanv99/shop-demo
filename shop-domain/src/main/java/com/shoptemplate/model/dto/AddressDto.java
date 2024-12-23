package com.shoptemplate.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "Street is required.")
    @Size(max = 100, message = "Street cannot exceed 100 characters.")
    private String street;

    @NotBlank(message = "City is required.")
    @Size(max = 50, message = "City cannot exceed 50 characters.")
    private String city;

    @NotBlank(message = "State is required.")
    @Size(max = 50, message = "State cannot exceed 50 characters.")
    private String state;

    @NotBlank(message = "Zip Code is required.")
    @Size(max = 10, message = "Zip Code cannot exceed 10 characters.")
    private String zipCode;

    @NotEmpty(message = "Country is required.")
    private Long country;
}
