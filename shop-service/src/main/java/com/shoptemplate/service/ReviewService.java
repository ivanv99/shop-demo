package com.shoptemplate.service;

import com.shoptemplate.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();

    Optional<Review> getReviewById(int id);

    void createReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);
}
