package com.ivanvelev.repositories;

import com.ivanvelev.models.User;
import com.ivanvelev.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> getAllUsers() {
        try (Session session = SessionUtil.getSession()) {
            Query<User> query = session.createQuery("from users ", User.class);
            return query.getResultList();
        }
    }

    @Override
    public User getUserById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<User> query = session.createQuery("from users u where u.id=:id", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public void createUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }
}
