package com.u238.training.dao;

import com.u238.training.entity.Customer;
import com.u238.training.utils.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAORegular implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAORegular(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = currentSession.createQuery("from Customer order by id", Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
    Session currentSession = sessionFactory.getCurrentSession();
        Query query=currentSession.createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List searchCustomer(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery;

        if (theSearchName != null && theSearchName.trim().length() > 0) {

            theQuery = currentSession.createQuery("from Customer where " +
                    "(lower(lastName) like :name" +
                    " or lower(firstName) like :name" +
                    " or lower(email) like :name)",Customer.class);

            theQuery.setParameter("name", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = currentSession.createQuery("from Customer ", Customer.class);
        }

        return theQuery.getResultList();
    }

    @Override
    public List<Customer> getCustomerSorted(int theSortField) {
        Session currentSession = sessionFactory.getCurrentSession();

        String theFieldName;

        switch (theSortField) {
            case SortUtils.FIRST_NAME:
                theFieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                theFieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                theFieldName = "email";
                break;
            default:
                theFieldName = "lastName";
        }
        String queryString = "from Customer order by " + theFieldName;
        Query<Customer> theQuery = currentSession.createQuery(queryString, Customer.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }
}
