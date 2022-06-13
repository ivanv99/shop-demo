package com.ivanvelev.repositories;

import com.ivanvelev.models.Order;
import com.ivanvelev.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{


    @Override
    public List<Order> getAllOrders() {
        try (Session session = SessionUtil.getSession()) {
            Query<Order> query = session.createQuery("from orders ", Order.class);
            return query.getResultList();
        }
    }

    @Override
    public Order getOrderById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Order> query = session.createQuery("from orders o where o.id=:id", Order.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public void createOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
        }
    }

    @Override
    public void deleteOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(order);
            transaction.commit();
        }
    }
}
