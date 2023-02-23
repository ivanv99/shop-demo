package com.ivanvelev.controllers.rest;

import com.ivanvelev.controllers.utils.ModelMapper;
import com.ivanvelev.models.Customer;
import com.ivanvelev.models.dto.CustomerDto;
import com.ivanvelev.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Customer> getAllUsers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer create(@RequestBody CustomerDto customerDto) {
        Customer user = modelMapper.convertToCustomerFromDto(customerDto);
        customerService.createCustomer(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        Customer user = customerService.getCustomerById(id);
        customerService.deleteCustomer(user);
        return user;
    }
}
