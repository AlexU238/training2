package com.u238.training.service;

import com.u238.training.entity.Customer;

import java.util.List;

public interface CustomerService {

    List getCustomerList();

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List searchCustomer(String theSearchName);

    List getCustomerListSorted(int theSortField);

    void saveCustomer(Customer customer);
}
