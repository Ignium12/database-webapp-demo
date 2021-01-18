package com.kruehl.springdemo.dao;

import com.kruehl.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
