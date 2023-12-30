package com.shoptemplate.repositories;

import com.shoptemplate.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}