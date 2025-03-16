package com.shoptemplate.service.impl;

import com.shoptemplate.model.Review;
import com.shoptemplate.repositories.ReviewRepository;
import com.shoptemplate.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.saveAndFlush(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.saveAndFlush(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }
}
