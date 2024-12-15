package com.shoptemplate.controller.utils;

import com.shoptemplate.model.Address;
import com.shoptemplate.model.Country;
import com.shoptemplate.model.User;
import com.shoptemplate.model.dto.AddressDto;
import com.shoptemplate.model.dto.CountryDto;
import com.shoptemplate.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {


    public ModelMapper() {
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
        return address;
    }

    public AddressDto convertToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        return addressDto;
    }
}
