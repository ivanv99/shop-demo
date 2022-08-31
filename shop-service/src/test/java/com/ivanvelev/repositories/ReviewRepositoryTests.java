package com.ivanvelev.repositories;

import com.ivanvelev.models.Address;
import com.ivanvelev.models.Item;
import com.ivanvelev.models.Review;
import com.ivanvelev.models.User;
import com.ivanvelev.utils.HibernateTestsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReviewRepositoryTests {

    private final CountryRepository countryRepository = new CountryRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final AddressRepository addressRepository = new AddressRepositoryImpl();
    private final ItemRepository itemRepository = new ItemRepositoryImpl();
    private final ReviewRepository reviewRepository = new ReviewRepositoryImpl();

    @Test
    public void test() {
        Address oneAddress = HibernateTestsUtil.address(countryRepository.getCountryById(1), "Sofia, Mladost");
        Address twoAddress = HibernateTestsUtil.address(countryRepository.getCountryById(2), "New York, Str");
        Address threeAddress = HibernateTestsUtil.address(countryRepository.getCountryById(3), "Moscow, Str");
        Address fourAddress = HibernateTestsUtil.address(countryRepository.getCountryById(4), "London, Str");
        Address fiveAddress = HibernateTestsUtil.address(countryRepository.getCountryById(5), "Berlin, Str");

        addressRepository.createAddress(oneAddress);
        addressRepository.createAddress(twoAddress);
        addressRepository.createAddress(threeAddress);
        addressRepository.createAddress(fourAddress);
        addressRepository.createAddress(fiveAddress);

        User oneUser = HibernateTestsUtil.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
        User twoUser = HibernateTestsUtil.user("Georgi", "Ivanov", "g.ivanov@gmail.com", "givanov", "asdfghjkl");
        User threeUser = HibernateTestsUtil.user("Daniel", "Nikolov", "d.nikolov@gmail.com", "dnikolov", "asdfghjkl");
        User fourUser = HibernateTestsUtil.user("Ivan", "Ivanov", "i.ivanov@gmail.com", "iivanov", "asdfghjkl");
        User fiveUser = HibernateTestsUtil.user("Aleksandar", "Stoyanov", "a.stoqnov@gmail.com", "astoyanov", "asdfghjkl");

        userRepository.createUser(oneUser);
        userRepository.createUser(twoUser);
        userRepository.createUser(threeUser);
        userRepository.createUser(fourUser);
        userRepository.createUser(fiveUser);

        Item oneItem = HibernateTestsUtil.item("bike", 1);
        Item twoItem = HibernateTestsUtil.item("book", 2);
        Item threeItem = HibernateTestsUtil.item("apple", 3);
        Item fourItem = HibernateTestsUtil.item("phone", 4);
        Item fiveItem = HibernateTestsUtil.item("laptop", 5);

        itemRepository.createItem(oneItem);
        itemRepository.createItem(twoItem);
        itemRepository.createItem(threeItem);
        itemRepository.createItem(fourItem);
        itemRepository.createItem(fiveItem);

        Review reviewOne = HibernateTestsUtil.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue())
                , itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue()));
        Review reviewTwo = HibernateTestsUtil.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(1).getId().intValue())
                , itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue()));
        Review reviewThree = HibernateTestsUtil.review("Good product", userRepository.getUserById(userRepository.getAllUsers().get(2).getId().intValue())
                , itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()));

        reviewRepository.createReview(reviewOne);
        reviewRepository.createReview(reviewTwo);
        reviewRepository.createReview(reviewThree);

        Assertions.assertEquals(3, reviewRepository.getAllReviews().size());

        Review reviewToChange = reviewRepository.getReviewById(reviewRepository.getAllReviews().get(0).getId().intValue());
        reviewToChange.setReview("There is a problem with the product");

        reviewRepository.updateReview(reviewToChange);

        Assertions.assertEquals("There is a problem with the product", reviewRepository.getReviewById(reviewRepository.getAllReviews().get(reviewRepository.getAllReviews().size() - 1).getId().intValue()).getReview());

        reviewRepository.deleteReview(reviewOne);
        reviewRepository.deleteReview(reviewTwo);
        reviewRepository.deleteReview(reviewThree);

        Assertions.assertEquals(0, reviewRepository.getAllReviews().size());

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
