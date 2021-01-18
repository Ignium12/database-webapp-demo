package com.kruehl.springdemo.dao;

import com.kruehl.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override // no @Transactional -> moved to service layer
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create the query ... sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
                Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        System.out.println(customers);

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer...finally LOL
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class,id);
        return customer;
    }
}
