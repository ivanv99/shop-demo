package com.ivanvelev.controllers.rest;

import com.ivanvelev.controllers.utils.ModelMapper;
import com.ivanvelev.models.Review;
import com.ivanvelev.models.dto.ReviewDto;
import com.ivanvelev.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewController(ReviewService reviewService,
                            ModelMapper modelMapper) {
        this.reviewService = reviewService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable int id) {
        return reviewService.getReviewById(id);

    }

    @PostMapping("/{itemId}")
    public Review create(@RequestBody ReviewDto reviewDto,
                         @PathVariable int itemId) {
        Review review = modelMapper.fromDto(reviewDto);
        reviewService.createReview(review);
        return review;

    }

    @PutMapping("/{itemId}/{id}")
    public Review update(@PathVariable int id, @RequestBody ReviewDto reviewDto,
                         @PathVariable int itemId) {
        Review review = modelMapper.fromDto(reviewDto, id);
        reviewService.updateReview(review);
        return review;
    }

    @DeleteMapping("/{itemId}/{id}")
    public Review delete(@PathVariable int id,
                         @PathVariable int itemId) {
        Review review = getById(id);
        reviewService.deleteReview(review);
        return review;
    }

}
