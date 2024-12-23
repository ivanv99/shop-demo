package com.shoptemplate.service;

import com.shoptemplate.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(Long id);

    void createAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(Address address);
}
