package com.shoptemplate.service.impl;

import com.shoptemplate.model.Country;
import com.shoptemplate.repositories.CountryRepository;
import com.shoptemplate.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void createCountry(Country country) {
        countryRepository.saveAndFlush(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryRepository.saveAndFlush(country);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }
}
