package com.ivanvelev.controllers.utils;

import com.ivanvelev.models.Customer;
import com.ivanvelev.models.Review;
import com.ivanvelev.models.dto.CustomerDto;
import com.ivanvelev.models.dto.ReviewDto;
import com.ivanvelev.repositories.ItemRepository;
import com.ivanvelev.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ModelMapper(ReviewRepository reviewRepository, ItemRepository itemRepository) {
        this.reviewRepository = reviewRepository;
        this.itemRepository = itemRepository;
    }

    public Customer convertToCustomerFromDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public Review fromDto(ReviewDto reviewDto) {
        Review review = new Review();
        dtoToObject(review, reviewDto);
        return review;
    }

    public Review fromDto(ReviewDto reviewDto, int id) {
        Review review = reviewRepository.getReviewById(id);
        dtoToObject(review, reviewDto);
        return review;
    }

    private void dtoToObject(Review review, ReviewDto reviewDto) {
        review.setName(reviewDto.getName());
        review.setReview(reviewDto.getReview());
        review.setItem(itemRepository.getItemById(reviewDto.getItemId()));
    }

}
