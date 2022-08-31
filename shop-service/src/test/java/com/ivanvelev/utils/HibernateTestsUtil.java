package com.ivanvelev.utils;

import com.ivanvelev.models.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HibernateTestsUtil {

    public static Address address(Country country, String addressDetails) {
        Address address = new Address();
        address.setCountry(country);
        address.setAddressDetails(addressDetails);
        return address;
    }

    public static User user(String firstName, String lastName, String email, String username, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        UserCredentials userCredentials = new UserCredentials();
        user.setUserCredentials(userCredentials);
        user.getUserCredentials().setEmail(email);
        user.getUserCredentials().setUsername(username);
        user.getUserCredentials().setPassword(password);
        return user;
    }

    public static Item item(String name, float price) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        return item;
    }

    public static Order order(User user, Address address, List<Item> items) {
        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setOrderItems(items);
        order.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return order;
    }

    public static List<Item> itemList(Item... items) {
        return new ArrayList<>(List.of(items));
    }

    public static Review review(String reviewDetails, User user, Item item) {
        Review review = new Review();
        review.setReview(reviewDetails);
        review.setUser(user);
        review.setItem(item);
        review.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return review;
    }
}
