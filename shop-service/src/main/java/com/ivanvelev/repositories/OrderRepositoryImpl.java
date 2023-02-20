package com.ivanvelev.repositories;

import com.ivanvelev.models.Order;
import com.ivanvelev.utils.SessionUtil;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderRepositoryImpl implements OrderRepository {


    @Override
    public List<Order> getAllOrders() {
        try (Session session = SessionUtil.getSession()) {
            Query<Order> query = session.createQuery("from order ", Order.class);
            return query.getResultList();
        }
    }

    @Override
    public Order getOrderById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Order> query = session.createQuery("from order o where o.id=:id", Order.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    @Transactional
    public void createOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(order);
            transaction.commit();
        }
    }
}
