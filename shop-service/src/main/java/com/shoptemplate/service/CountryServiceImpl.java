package com.shoptemplate.service;

import com.shoptemplate.model.Country;
import com.shoptemplate.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

//    @Autowired
//    public CountryServiceImpl(CountryRepository countryRepository) {
//        this.countryRepository = countryRepository;
//    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(int id) {
        return countryRepository.findById((long) id);
    }
}
