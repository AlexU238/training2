package com.u238.training.service;

import com.u238.training.dao.CustomerDAO;
import com.u238.training.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceRegular implements CustomerService{

    CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceRegular(@Qualifier("customerDAORegular") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    @Override
    @Transactional
    public List getCustomerList() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List searchCustomer(String theSearchName) {
        return customerDAO.searchCustomer(theSearchName);
    }

    @Override
    @Transactional
    public List getCustomerListSorted(int theSortField) {
        return  customerDAO.getCustomerSorted(theSortField);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
}
