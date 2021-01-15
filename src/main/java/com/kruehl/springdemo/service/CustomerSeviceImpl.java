package com.kruehl.springdemo.service;

import com.kruehl.springdemo.dao.CustomerDAO;
import com.kruehl.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerSeviceImpl implements CustomerService {

    // need to inject the customer dao

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional // service layer defines beginning and end of an transaction
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
