package com.u238.training.configs;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

public interface SpringConfigMySQLHibernate {

    DataSource MySQLDataSource(String url);

    Properties getHibernateProperties();

    LocalSessionFactoryBean getSessionFactory(DataSource dataSource);

    HibernateTransactionManager transactionManager(SessionFactory sessionFactory);
}
