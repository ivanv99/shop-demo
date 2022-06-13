package com.ivanvelev.repositories;

import com.ivanvelev.models.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> getAllCountries();

    Country getCountryById(int id);
}
