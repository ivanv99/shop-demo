package com.shoptemplate.model.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ReviewDto {

    private String review;

    private int itemId;

    private String name;

    public ReviewDto() {
    }

    public ReviewDto(String review, int itemId, String name) {
        this.review = review;
        this.itemId = itemId;
        this.name = name;
    }

}
