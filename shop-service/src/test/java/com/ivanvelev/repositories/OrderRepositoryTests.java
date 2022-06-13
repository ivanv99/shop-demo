package com.ivanvelev.repositories;

import com.ivanvelev.models.Address;
import com.ivanvelev.models.Item;
import com.ivanvelev.models.Order;
import com.ivanvelev.models.User;
import com.ivanvelev.util.Util;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class OrderRepositoryTests {

    private final CountryRepository countryRepository = new CountryRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final AddressRepository addressRepository = new AddressRepositoryImpl();
    private final ItemRepository itemRepository = new ItemRepositoryImpl();
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

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

        Order orderOne = Util.order(userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue()),
                addressRepository.getAddressById(addressRepository.getAllAddresses().get(0).getId().intValue()),
                Util.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue()),
                        itemRepository.getItemById(itemRepository.getAllItems().get(2).getId().intValue())));

        Order orderTwo =  Util.order(userRepository.getUserById(userRepository.getAllUsers().get(1).getId().intValue()),
                addressRepository.getAddressById(addressRepository.getAllAddresses().get(1).getId().intValue()),
                Util.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue()),
                        itemRepository.getItemById(itemRepository.getAllItems().get(3).getId().intValue())));

        Order orderThree =  Util.order(userRepository.getUserById(userRepository.getAllUsers().get(2).getId().intValue()),
                addressRepository.getAddressById(addressRepository.getAllAddresses().get(2).getId().intValue()),
                Util.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
                        itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
                        itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue())));

        orderRepository.createOrder(orderOne);
        orderRepository.createOrder(orderTwo);
        orderRepository.createOrder(orderThree);

        Assert.assertEquals(3, orderRepository.getAllOrders().size());

        Order orderToChange = orderRepository.getOrderById(orderRepository.getAllOrders().get(2).getId().intValue());

        orderToChange.setOrderItems(Util.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
                itemRepository.getItemById(itemRepository.getAllItems().get(3).getId().intValue()),
                itemRepository.getItemById(itemRepository.getAllItems().get(2).getId().intValue()),
                itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue())));

        orderRepository.updateOrder(orderToChange);

        Assert.assertEquals(4, orderRepository.getOrderById(orderRepository.getAllOrders().get(2).getId().intValue()).getOrderItems().size());

        orderRepository.deleteOrder(orderOne);
        orderRepository.deleteOrder(orderTwo);
        orderRepository.deleteOrder(orderThree);

        Assert.assertEquals(0, orderRepository.getAllOrders().size());

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
