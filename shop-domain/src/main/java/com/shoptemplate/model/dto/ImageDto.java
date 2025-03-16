package com.shoptemplate.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    @NotBlank(message = "Image data is required.")
    private byte[] imageData;

    @NotBlank(message = "Image name is required.")
    private String imageName;
}
