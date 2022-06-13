package com.ivanvelev.repositories;

import com.ivanvelev.models.Address;
import com.ivanvelev.util.Util;
import org.junit.Assert;
import org.junit.Test;

public class AddressRepositoryTests {

    private final CountryRepository countryRepository = new CountryRepositoryImpl();
    private final AddressRepository addressRepository = new AddressRepositoryImpl();

    @Test
    public void test() {
        Address one = Util.address(countryRepository.getCountryById(1), "Sofia, Mladost");
        Address two = Util.address(countryRepository.getCountryById(2), "New York, Str");
        Address three = Util.address(countryRepository.getCountryById(3), "Moscow, Str");
        Address four = Util.address(countryRepository.getCountryById(4), "London, Str");
        Address five = Util.address(countryRepository.getCountryById(5), "Berlin, Str");

        addressRepository.createAddress(one);
        addressRepository.createAddress(two);
        addressRepository.createAddress(three);
        addressRepository.createAddress(four);
        addressRepository.createAddress(five);

        Assert.assertEquals(5, addressRepository.getAllAddresses().size());
        Assert.assertEquals("Bulgaria", addressRepository.getAddressById(addressRepository.getAllAddresses().get(0).getId().intValue()).getCountry().getCountry());

        addressRepository.deleteAddress(one);
        addressRepository.deleteAddress(two);
        addressRepository.deleteAddress(three);
        addressRepository.deleteAddress(four);
        addressRepository.deleteAddress(five);

        Assert.assertEquals(0, addressRepository.getAllAddresses().size());
    }

}
