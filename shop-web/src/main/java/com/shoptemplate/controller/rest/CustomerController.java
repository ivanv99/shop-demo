package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.Customer;
import com.shoptemplate.model.dto.CustomerDto;
import com.shoptemplate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Customer> getAllUsers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        if (customerService.getCustomerById(id).isPresent()) {
            return customerService.getCustomerById(id).get();
        }
        return null;
    }

    @PostMapping
    public Customer create(@RequestBody CustomerDto customerDto) {
        Customer user = modelMapper.convertToCustomerFromDto(customerDto);
        customerService.createCustomer(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        if (customerService.getCustomerById(id).isPresent()) {
            Customer user = customerService.getCustomerById(id).get();
            customerService.deleteCustomer(user);
            return user;
        }
        return null;
    }
}
