package com.ivanvelev.services;

import com.ivanvelev.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(int id);

    void createItem(Item item);

    void updateItem(Item item);

    void deleteItem(Item item);
}
