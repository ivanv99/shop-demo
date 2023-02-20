package com.ivanvelev.repositories;

import com.ivanvelev.models.User;
import com.ivanvelev.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> getAllUsers() {
        try (Session session = SessionUtil.getSession()) {
            Query<User> query = session.createQuery("from user ", User.class);
            return query.getResultList();
        }
    }

    @Override
    public User getUserById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<User> query = session.createQuery("from user u where u.id=:id", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    @Transactional
    public void createUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user.getUserCredentials());
            session.persist(user);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }
}
