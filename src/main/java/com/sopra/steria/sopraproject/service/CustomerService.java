package com.sopra.steria.sopraproject.service;

import com.sopra.steria.sopraproject.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
    public List<Customer> getCustom(String value);
}
