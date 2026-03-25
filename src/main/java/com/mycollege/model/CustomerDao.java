package com.mycollege.model;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Console;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mycollege.util.HibernateUtil;

import com.mycollege.util.HibernateUtil;

public class CustomerDao {

	// Persist customer record
	public void saveCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.persist(customer);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	// Get customer list
	public List<Customer> getCustomerList() {
		List<Customer> customers = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            //transaction = session.beginTransaction();
            // Get all customer records
            customers = session.createQuery("from Customer", Customer.class).list();
            customers.forEach(customer -> System.out.println("Username: " + customer.getUsername() + ", Email: " + customer.getEmail()));
            // commit transaction
            //transaction.commit();
        } catch (Exception e) {
            //if (transaction != null) {
            //    transaction.rollback();
            //}
            e.printStackTrace();
        }
        return customers;
    }
	
	//find customer
	public Customer findCustomer(String username, String password) {

	    Transaction transaction = null;
	    Customer customer = null;

	    try (Session session =
	            HibernateUtil.getSessionFactory().openSession()) {

	        // start transaction
	        transaction = session.beginTransaction();

	        // HQL query
	        Query<Customer> query = session.createQuery(
	                "from Customer where username = :u and password = :p",
	                Customer.class);

	        query.setParameter("u", username);
	        query.setParameter("p", password);

	        // get single result
	        customer = query.uniqueResult();

	        transaction.commit();

	    } catch (Exception e) {

	        if (transaction != null) {
	            transaction.rollback();
	        }

	        e.printStackTrace();
	    }

	    return customer;
	}
	
}