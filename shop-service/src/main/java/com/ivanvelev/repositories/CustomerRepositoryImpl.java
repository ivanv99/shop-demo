package com.ivanvelev.repositories;

import com.ivanvelev.models.Customer;
import com.ivanvelev.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public List<Customer> getAllCustomers() {
        try (Session session = SessionUtil.getSession()) {
            Query<Customer> query = session.createQuery("from customer ", Customer.class);
            return query.getResultList();
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Customer> query = session.createQuery("from customer c where c.id= :id ", Customer.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(customer);
            transaction.commit();
        }
    }
}
