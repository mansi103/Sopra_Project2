package com.sopra.steria.sopraproject.service;

import com.sopra.steria.sopraproject.dao.CustomerDAO;
import com.sopra.steria.sopraproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        // TODO Auto-generated method stub;
        customerDao.saveCustomer(theCustomer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        // TODO Auto-generated method stub
        return customerDao.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        // TODO Auto-generated method stub

        customerDao.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public List<Customer> getCustom(String value) {
        return customerDao.getCustom(value);
    }
}
