package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Review;
import com.shoptemplate.model.dto.ReviewDto;
import com.shoptemplate.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

//    private final ReviewService reviewService;
//    private final ModelMapper modelMapper;
//
//    public ReviewController(ReviewService reviewService, ModelMapper modelMapper) {
//        this.reviewService = reviewService;
//        this.modelMapper = modelMapper;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ReviewDto>> getAll() {
//        List<ReviewDto> reviews = reviewService.getAllReviews().stream()
//                .map(modelMapper::toDto)
//                .toList();
//        return ResponseEntity.ok(reviews);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ReviewDto> getById(@PathVariable int id) {
//        return reviewService.getReviewById(id)
//                .map(review -> ResponseEntity.ok(modelMapper.toDto(review)))
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//    }
//
//    @PostMapping("/{itemId}")
//    public ResponseEntity<ReviewDto> create(@PathVariable int itemId, @RequestBody @Valid ReviewDto reviewDto) {
//        Review review = modelMapper.fromDto(reviewDto);
//        review.setItemId(itemId); // Associate the review with the item
//        reviewService.createReview(review);
//        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.toDto(review));
//    }
//
//    @PutMapping("/{itemId}/{id}")
//    public ResponseEntity<ReviewDto> update(@PathVariable int id, @PathVariable int itemId, @RequestBody @Valid ReviewDto reviewDto) {
//        return reviewService.getReviewById(id)
//                .filter(review -> review.getItem().getId() == itemId)
//                .map(existingReview -> {
//                    Review review = modelMapper.fromDto(reviewDto, id);
//                    review.setItemId(itemId); // Ensure the item association remains
//                    reviewService.updateReview(review);
//                    return ResponseEntity.ok(modelMapper.toDto(review));
//                })
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//    }
//
//    @DeleteMapping("/{itemId}/{id}")
//    public ResponseEntity<ReviewDto> delete(@PathVariable int id, @PathVariable int itemId) {
//        return reviewService.getReviewById(id)
//                .filter(review -> review.getItem().getId() == itemId)
//                .map(review -> {
//                    reviewService.deleteReview(review);
//                    return ResponseEntity.ok(modelMapper.toDto(review));
//                })
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//    }
}
