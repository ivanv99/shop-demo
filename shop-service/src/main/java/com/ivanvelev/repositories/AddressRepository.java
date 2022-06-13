package com.ivanvelev.repositories;

import com.ivanvelev.models.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> getAllAddresses();

    Address getAddressById(int id);

    void createAddress(Address address);

    void deleteAddress(Address address);
}
