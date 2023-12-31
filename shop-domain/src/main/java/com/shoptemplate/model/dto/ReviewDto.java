package com.shoptemplate.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private String review;
    private int itemId;
    private String name;
}