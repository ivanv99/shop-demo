package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Image;
import com.shoptemplate.model.Item;
import com.shoptemplate.model.dto.ItemDto;
import com.shoptemplate.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto, @RequestParam(value = "images") MultipartFile[] images) throws IOException {
        Item item = modelMapper.convertFromDto(itemDto);
        item.setImages(convertImagesToEntities(images));
        itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convertToDto(item));
    }

    private List<byte[]> convertImagesToBytes(MultipartFile[] images) throws IOException {
        List<byte[]> imageDataList = new ArrayList<>();
        for (MultipartFile image : images) {
            imageDataList.add(image.getBytes());
        }
        return imageDataList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto, @RequestParam(value = "images", required = false) MultipartFile[] images) {
        return itemService.getItemById(id)
                .map(existingItem -> {
                    existingItem = modelMapper.convertFromDto(itemDto);
                    try {
                        existingItem.setImages(convertImagesToEntities(images));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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

    private List<Image> convertImagesToEntities(MultipartFile[] images) throws IOException {
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile image : images) {
            Image imageEntity = new Image();
            imageEntity.setImageData(image.getBytes());
            imageEntity.setImageName(image.getName());
            imageList.add(imageEntity);
        }
        return imageList;
    }
}
