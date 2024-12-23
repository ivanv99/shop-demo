package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Item;
import com.shoptemplate.model.dto.ItemDto;
import com.shoptemplate.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems()
                .stream()
                .map(modelMapper::convertToDto)
                .toList();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(item -> ResponseEntity.ok(modelMapper.convertToDto(item)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        Item item = modelMapper.convertFromDto(itemDto);
        itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convertToDto(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.getItemById(id)
                .map(existingItem -> {
                    existingItem = modelMapper.convertFromDto(itemDto);
                    itemService.updateItem(existingItem);
                    return ResponseEntity.ok(modelMapper.convertToDto(existingItem));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(item -> {
                    itemService.deleteItem(item);
                    return ResponseEntity.ok(modelMapper.convertToDto(item));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
