package com.shoptemplate.repositories;

import com.shoptemplate.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}