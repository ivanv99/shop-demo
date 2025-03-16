package com.shoptemplate.service.impl;

import com.shoptemplate.model.Address;
import com.shoptemplate.repositories.AddressRepository;
import com.shoptemplate.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void createAddress(Address address) {
        addressRepository.saveAndFlush(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressRepository.saveAndFlush(address);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }
}
