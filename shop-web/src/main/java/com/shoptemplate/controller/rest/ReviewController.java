package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Review;
import com.shoptemplate.model.dto.ReviewDto;
import com.shoptemplate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable int id) {
        if (reviewService.getReviewById(id).isPresent()) {
            return reviewService.getReviewById(id).get();
        }
        return null;
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
