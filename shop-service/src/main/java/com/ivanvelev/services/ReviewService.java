package com.ivanvelev.services;

import com.ivanvelev.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(int id);

    void createReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);
}
