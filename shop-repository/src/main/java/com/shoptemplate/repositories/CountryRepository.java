package com.shoptemplate.repositories;

import com.shoptemplate.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}