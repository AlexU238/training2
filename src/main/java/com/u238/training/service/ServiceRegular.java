package com.u238.training.service;

import com.u238.training.entity.Customer;

import java.util.List;

public interface ServiceRegular <T>{

    List getList();

    T get(int id);

    void delete(int id);

    List search(String theSearchName);

    List getListSorted(int theSortField);

    void save(T entity);
}
