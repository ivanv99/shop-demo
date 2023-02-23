package com.ivanvelev.repositories;

import com.ivanvelev.models.Customer;
import com.ivanvelev.models.Item;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
