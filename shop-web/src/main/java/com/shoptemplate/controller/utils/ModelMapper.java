package com.shoptemplate.controller.utils;

import com.shoptemplate.model.User;
import com.shoptemplate.model.Item;
import com.shoptemplate.model.Review;
import com.shoptemplate.model.dto.UserDto;
import com.shoptemplate.model.dto.ReviewDto;
import com.shoptemplate.repositories.ItemRepository;
import com.shoptemplate.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ModelMapper {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ModelMapper(ReviewRepository reviewRepository, ItemRepository itemRepository) {
        this.reviewRepository = reviewRepository;
        this.itemRepository = itemRepository;
    }

    public User convertToUserFromDto(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public Review fromDto(ReviewDto reviewDto) {
        Review review = new Review();
        dtoToObject(review, reviewDto);
        return review;
    }

    public Review fromDto(ReviewDto reviewDto, int id) {
        Optional<Review> review = reviewRepository.findById((long) id);
        if (review.isPresent()) {
            dtoToObject(review.get(), reviewDto);
            return review.get();
        }
        return null;
    }

    private void dtoToObject(Review review, ReviewDto reviewDto) {
        review.setName(reviewDto.getName());
        review.setReview(reviewDto.getReview());
        Optional<Item> itemOptional = itemRepository.findById((long) reviewDto.getItemId());
        itemOptional.ifPresent(review::setItem);
    }

}
