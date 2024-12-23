package com.shoptemplate.service;

import com.shoptemplate.model.Item;
import com.shoptemplate.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void createItem(Item item) {
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }
}
