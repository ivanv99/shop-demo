package com.ivanvelev.repositories;

import com.ivanvelev.models.Country;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CountryRepositoryTests {

    private final CountryRepository repository = new CountryRepositoryImpl();

    @Test
    public void testGetAllCountriesReturnNotEmpty() {
        Assert.assertEquals(5,repository.getAllCountries().size());
    }

    @Test
    public void testGetCountryByIdReturnSame() {
        Assert.assertEquals(1, repository.getCountryById(1).getId().intValue());
        Assert.assertEquals("Bulgaria", repository.getCountryById(1).getCountry());
    }

}
