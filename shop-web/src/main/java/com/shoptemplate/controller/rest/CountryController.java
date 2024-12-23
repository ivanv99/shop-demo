package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Country;
import com.shoptemplate.model.dto.CountryDto;
import com.shoptemplate.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;
    private final ModelMapper modelMapper;

    public CountryController(CountryService countryService, ModelMapper modelMapper) {
        this.countryService = countryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countries = countryService.getAllCountries()
                .stream()
                .map(modelMapper::convertToDto)
                .toList();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(country -> ResponseEntity.ok(modelMapper.convertToDto(country)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        Country country = modelMapper.convertFromDto(countryDto);
        countryService.createCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convertToDto(country));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return countryService.getCountryById(id)
                .map(existingCountry -> {
                    existingCountry = modelMapper.convertFromDto(countryDto);
                    countryService.updateCountry(existingCountry);
                    return ResponseEntity.ok(modelMapper.convertToDto(existingCountry));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CountryDto> deleteCountry(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(country -> {
                    countryService.deleteCountry(country);
                    return ResponseEntity.ok(modelMapper.convertToDto(country));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
