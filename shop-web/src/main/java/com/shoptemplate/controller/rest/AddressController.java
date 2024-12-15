package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Address;
import com.shoptemplate.model.dto.AddressDto;
import com.shoptemplate.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final ModelMapper modelMapper;

    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> Addresses = addressService.getAllAddresses()
                .stream()
                .map(modelMapper::convertToDto)
                .toList();
        return ResponseEntity.ok(Addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable int id) {
        return addressService.getAddressById(id)
                .map(Address -> ResponseEntity.ok(modelMapper.convertToDto(Address)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        Address address = modelMapper.convertFromDto(addressDto);
        addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convertToDto(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable int id, @RequestBody AddressDto AddressDto) {
        return addressService.getAddressById(id)
                .map(existingAddress -> {
                    existingAddress = modelMapper.convertFromDto(AddressDto);
                    addressService.updateAddress(existingAddress);
                    return ResponseEntity.ok(modelMapper.convertToDto(existingAddress));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressDto> deleteAddress(@PathVariable int id) {
        return addressService.getAddressById(id)
                .map(address -> {
                    addressService.deleteAddress(address);
                    return ResponseEntity.ok(modelMapper.convertToDto(address));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
