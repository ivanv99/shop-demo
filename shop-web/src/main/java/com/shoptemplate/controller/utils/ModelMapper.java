package com.shoptemplate.controller.utils;

import com.shoptemplate.model.*;
import com.shoptemplate.model.dto.*;
import com.shoptemplate.repositories.AddressRepository;
import com.shoptemplate.repositories.CountryRepository;
import com.shoptemplate.repositories.ItemRepository;
import com.shoptemplate.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    private final CountryRepository countryRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public ModelMapper(CountryRepository countryRepository, AddressRepository addressRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.countryRepository = countryRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public User convertFromDto(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public CountryDto convertToDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountry(country.getCountry());
        return countryDto;
    }

    public Country convertFromDto(CountryDto countryDto) {
        Country country = new Country();
        country.setCountry(countryDto.getCountry());
        return country;
    }

    public Address convertFromDto(AddressDto addressDto) {
        Address address = new Address();
        address.setCountry(countryRepository.findById(addressDto.getCountry()).orElse(null));
        address.setCity(address.getCity());
        address.setState(addressDto.getState());
        address.setZipCode(address.getZipCode());
        address.setStreet(address.getStreet());
        return address;
    }

    public AddressDto convertToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(address.getCountry().getId());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(addressDto.getStreet());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setState(address.getState());
        return addressDto;
    }

    public ItemDto convertToDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        return itemDto;
    }

    public Item convertFromDto(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    }

    public OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAddress(order.getAddress().getId());
        orderDto.setUser(order.getUser().getId());
        orderDto.setOrderItems(order.getOrderItems().stream().map(Item::getId).toList());
        orderDto.setTimestamp(order.getTimestamp());
        return orderDto;
    }

    public Order convertFromDto(OrderDto orderDto) {
        Order order = new Order();
        order.setAddress(addressRepository.findById(orderDto.getAddress()).orElse(null));
        order.setUser(userRepository.findById(orderDto.getUser()).orElse(null));
        order.setOrderItems(itemRepository.findAllById(orderDto.getOrderItems()));
        order.setTimestamp(orderDto.getTimestamp());
        return order;
    }
}
