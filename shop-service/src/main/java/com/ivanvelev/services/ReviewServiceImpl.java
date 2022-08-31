package com.ivanvelev.services;

import com.ivanvelev.models.Review;
import com.ivanvelev.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepository.getReviewById(id);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.createReview(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.updateReview(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.deleteReview(review);
    }
}
