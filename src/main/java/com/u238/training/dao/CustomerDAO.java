package com.u238.training.dao;

import com.u238.training.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List searchCustomer(String theSearchName);

    List<Customer> getCustomerSorted(int theSortField);

    void saveCustomer(Customer customer);
}
