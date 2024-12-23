package com.shoptemplate.service;

import com.shoptemplate.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();

    Optional<Item> getItemById(Long id);

    void createItem(Item item);

    void updateItem(Item item);

    void deleteItem(Item item);
}
