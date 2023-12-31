package com.ivanvelev.repositories;

public class OrderRepositoryTests {

//    private final CountryRepository countryRepository = new CountryRepositoryImpl();
//    private final UserRepository userRepository = new UserRepositoryImpl();
//    private final AddressRepository addressRepository = new AddressRepositoryImpl();
//    private final ItemRepository itemRepository = new ItemRepositoryImpl();
//    private final OrderRepository orderRepository = new OrderRepositoryImpl();
//
//    @Test
//    public void test() {
//        Address oneAddress = HibernateTestsUtil.address(countryRepository.getCountryById(1), "Sofia, Mladost");
//        Address twoAddress = HibernateTestsUtil.address(countryRepository.getCountryById(2), "New York, Str");
//        Address threeAddress = HibernateTestsUtil.address(countryRepository.getCountryById(3), "Moscow, Str");
//        Address fourAddress = HibernateTestsUtil.address(countryRepository.getCountryById(4), "London, Str");
//        Address fiveAddress = HibernateTestsUtil.address(countryRepository.getCountryById(5), "Berlin, Str");
//
//        addressRepository.createAddress(oneAddress);
//        addressRepository.createAddress(twoAddress);
//        addressRepository.createAddress(threeAddress);
//        addressRepository.createAddress(fourAddress);
//        addressRepository.createAddress(fiveAddress);
//
//        User oneUser = HibernateTestsUtil.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
//        User twoUser = HibernateTestsUtil.user("Georgi", "Ivanov", "g.ivanov@gmail.com", "givanov", "asdfghjkl");
//        User threeUser = HibernateTestsUtil.user("Daniel", "Nikolov", "d.nikolov@gmail.com", "dnikolov", "asdfghjkl");
//        User fourUser = HibernateTestsUtil.user("Ivan", "Ivanov", "i.ivanov@gmail.com", "iivanov", "asdfghjkl");
//        User fiveUser = HibernateTestsUtil.user("Aleksandar", "Stoyanov", "a.stoqnov@gmail.com", "astoyanov", "asdfghjkl");
//
//        userRepository.createUser(oneUser);
//        userRepository.createUser(twoUser);
//        userRepository.createUser(threeUser);
//        userRepository.createUser(fourUser);
//        userRepository.createUser(fiveUser);
//
//        Item oneItem = HibernateTestsUtil.item("bike", 1);
//        Item twoItem = HibernateTestsUtil.item("book", 2);
//        Item threeItem = HibernateTestsUtil.item("apple", 3);
//        Item fourItem = HibernateTestsUtil.item("phone", 4);
//        Item fiveItem = HibernateTestsUtil.item("laptop", 5);
//
//        itemRepository.createItem(oneItem);
//        itemRepository.createItem(twoItem);
//        itemRepository.createItem(threeItem);
//        itemRepository.createItem(fourItem);
//        itemRepository.createItem(fiveItem);
//
//        Order orderOne = HibernateTestsUtil.order(userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue()),
//                addressRepository.getAddressById(addressRepository.getAllAddresses().get(0).getId().intValue()),
//                HibernateTestsUtil.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(0).getId().intValue()),
//                        itemRepository.getItemById(itemRepository.getAllItems().get(2).getId().intValue())));
//
//        Order orderTwo = HibernateTestsUtil.order(userRepository.getUserById(userRepository.getAllUsers().get(1).getId().intValue()),
//                addressRepository.getAddressById(addressRepository.getAllAddresses().get(1).getId().intValue()),
//                HibernateTestsUtil.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue()),
//                        itemRepository.getItemById(itemRepository.getAllItems().get(3).getId().intValue())));
//
//        Order orderThree = HibernateTestsUtil.order(userRepository.getUserById(userRepository.getAllUsers().get(2).getId().intValue()),
//                addressRepository.getAddressById(addressRepository.getAllAddresses().get(2).getId().intValue()),
//                HibernateTestsUtil.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
//                        itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
//                        itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue())));
//
//        orderRepository.createOrder(orderOne);
//        orderRepository.createOrder(orderTwo);
//        orderRepository.createOrder(orderThree);
//
//        Assertions.assertEquals(3, orderRepository.getAllOrders().size());
//
//        Order orderToChange = orderRepository.getOrderById(orderRepository.getAllOrders().get(2).getId().intValue());
//
//        orderToChange.setOrderItems(HibernateTestsUtil.itemList(itemRepository.getItemById(itemRepository.getAllItems().get(4).getId().intValue()),
//                itemRepository.getItemById(itemRepository.getAllItems().get(3).getId().intValue()),
//                itemRepository.getItemById(itemRepository.getAllItems().get(2).getId().intValue()),
//                itemRepository.getItemById(itemRepository.getAllItems().get(1).getId().intValue())));
//
//        orderRepository.updateOrder(orderToChange);
//
//        Assertions.assertEquals(4, orderRepository.getOrderById(orderRepository.getAllOrders().get(2).getId().intValue()).getOrderItems().size());
//
//        orderRepository.deleteOrder(orderOne);
//        orderRepository.deleteOrder(orderTwo);
//        orderRepository.deleteOrder(orderThree);
//
//        Assertions.assertEquals(0, orderRepository.getAllOrders().size());
//
//        addressRepository.deleteAddress(oneAddress);
//        addressRepository.deleteAddress(twoAddress);
//        addressRepository.deleteAddress(threeAddress);
//        addressRepository.deleteAddress(fourAddress);
//        addressRepository.deleteAddress(fiveAddress);
//
//        userRepository.deleteUser(oneUser);
//        userRepository.deleteUser(twoUser);
//        userRepository.deleteUser(threeUser);
//        userRepository.deleteUser(fourUser);
//        userRepository.deleteUser(fiveUser);
//
//        itemRepository.deleteItem(oneItem);
//        itemRepository.deleteItem(twoItem);
//        itemRepository.deleteItem(threeItem);
//        itemRepository.deleteItem(fourItem);
//        itemRepository.deleteItem(fiveItem);
//    }
}
