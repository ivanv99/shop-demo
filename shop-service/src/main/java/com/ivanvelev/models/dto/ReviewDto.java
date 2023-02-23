package com.ivanvelev.models.dto;

import org.jetbrains.annotations.NotNull;

public class ReviewDto {

    @NotNull
    private String review;

    @NotNull
    private int itemId;

    @NotNull
    private String name;

    public ReviewDto() {
    }

    public ReviewDto(@NotNull String review, @NotNull int itemId, @NotNull String name) {
        this.review = review;
        this.itemId = itemId;
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
