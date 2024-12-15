package com.shoptemplate.service;

import com.shoptemplate.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getAllCountries();

    Optional<Country> getCountryById(int id);

    void createCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(Country country);

}
