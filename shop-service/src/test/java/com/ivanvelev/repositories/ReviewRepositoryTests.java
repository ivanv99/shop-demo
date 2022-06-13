package com.ivanvelev.repositories;

import com.ivanvelev.models.*;
import com.ivanvelev.util.Util;
import org.junit.Assert;
import org.junit.Test;

public class ReviewRepositoryTests {

    private final CountryRepository countryRepository = new CountryRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final AddressRepository addressRepository = new AddressRepositoryImpl();
    private final ItemRepository itemRepository = new ItemRepositoryImpl();
    private final ReviewRepository reviewRepository = new ReviewRepositoryImpl();

    @Test
    public void test() {
        Address oneAddress = Util.address(countryRepository.getCountryById(1), "Sofia, Mladost");
        Address twoAddress = Util.address(countryRepository.getCountryById(2), "New York, Str");
        Address threeAddress = Util.address(countryRepository.getCountryById(3), "Moscow, Str");
        Address fourAddress = Util.address(countryRepository.getCountryById(4), "London, Str");
        Address fiveAddress = Util.address(countryRepository.getCountryById(5), "Berlin, Str");

        addressRepository.createAddress(oneAddress);
        addressRepository.createAddress(twoAddress);
        addressRepository.createAddress(threeAddress);
        addressRepository.createAddress(fourAddress);
        addressRepository.createAddress(fiveAddress);

        User oneUser = Util.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
        User twoUser = Util.user("Georgi", "Ivanov", "g.ivanov@gmail.com", "givanov", "asdfghjkl");
        User threeUser = Util.user("Daniel", "Nikolov", "d.nikolov@gmail.com", "dnikolov", "asdfghjkl");
        User fourUser = Util.user("Ivan", "Ivanov", "i.ivanov@gmail.com", "iivanov", "asdfghjkl");
        User fiveUser = Util.user("Aleksandar", "Stoyanov", "a.stoqnov@gmail.com", "astoyanov", "asdfghjkl");

        userRepository.createUser(oneUser);
        userRepository.createUser(twoUser);
        userRepository.createUser(threeUser);
        userRepository.createUser(fourUser);
        userRepository.createUser(fiveUser);

        Item oneItem = Util.item("bike",1);
        Item twoItem = Util.item("book",2);
        Item threeItem = Util.item("apple",3);
        Item fourItem = Util.item("phone",4);
        Item fiveItem = Util.item("laptop",5);

        itemRepository.createItem(oneItem);
        itemRepository.createItem(twoItem);
        itemRepository.createItem(threeItem);
        itemRepository.createItem(fourItem);
        itemRepository.createItem(fiveItem);

        Review reviewOne = Util.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue())
                ,itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue()));
        Review reviewTwo = Util.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(1).getId().intValue())
                ,itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue()));
        Review reviewThree = Util.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(2).getId().intValue())
                ,itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()));

        reviewRepository.createReview(reviewOne);
        reviewRepository.createReview(reviewTwo);
        reviewRepository.createReview(reviewThree);

        Assert.assertEquals(3, reviewRepository.getAllReviews().size());

        Review reviewToChange = reviewRepository.getReviewById(reviewRepository.getAllReviews().get(0).getId().intValue());
        reviewToChange.setReview("There is a problem with the product");

        reviewRepository.updateReview(reviewToChange);

        Assert.assertEquals("There is a problem with the product", reviewRepository.getReviewById(reviewRepository.getAllReviews().get(reviewRepository.getAllReviews().size()-1).getId().intValue()).getReview());

        reviewRepository.deleteReview(reviewOne);
        reviewRepository.deleteReview(reviewTwo);
        reviewRepository.deleteReview(reviewThree);

        Assert.assertEquals(0, reviewRepository.getAllReviews().size());

        addressRepository.deleteAddress(oneAddress);
        addressRepository.deleteAddress(twoAddress);
        addressRepository.deleteAddress(threeAddress);
        addressRepository.deleteAddress(fourAddress);
        addressRepository.deleteAddress(fiveAddress);

        userRepository.deleteUser(oneUser);
        userRepository.deleteUser(twoUser);
        userRepository.deleteUser(threeUser);
        userRepository.deleteUser(fourUser);
        userRepository.deleteUser(fiveUser);

        itemRepository.deleteItem(oneItem);
        itemRepository.deleteItem(twoItem);
        itemRepository.deleteItem(threeItem);
        itemRepository.deleteItem(fourItem);
        itemRepository.deleteItem(fiveItem);
    }

}
