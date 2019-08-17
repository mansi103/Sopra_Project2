package com.sopra.steria.sopraproject.dao;

import com.sopra.steria.sopraproject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //aab iss class ki jarurat nhi hai
    //areyy kyu aise kaise
    //jo maine class bnai usne saare kaam kr diya
    //query dekh ye
    //ruk
    //aab kya reh gya??
    //ho gaya?
    //webcontent kha se ayega?

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // TODO Auto-generated method stub
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // TODO Auto-generated method stub
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        // TODO Auto-generated method stub
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId){
        // TODO Auto-generated method stub
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();

    }
    @Override
    public List<Customer> getCustom(String value) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer where month='"+value+"'",Customer.class);
        List<Customer> custom = theQuery.getResultList();
        return custom;
    }
}
