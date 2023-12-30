package com.shoptemplate.controller.rest;

import com.shoptemplate.model.Country;
import com.shoptemplate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable int id) {
        if (countryService.getCountryById(id).isPresent()) {
            return countryService.getCountryById(id).get();
        }
        return null;
    }

}
