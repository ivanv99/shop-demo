package com.ivanvelev.repositories;

import com.ivanvelev.models.Country;
import com.ivanvelev.models.Item;
import com.ivanvelev.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepository{
    @Override
    public List<Item> getAllItems() {
        try (Session session = SessionUtil.getSession()) {
            Query<Item> query = session.createQuery("from item ", Item.class);
            return query.getResultList();
        }
    }

    @Override
    public Item getItemById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Item> query = session.createQuery("from item c where c.id= :id ", Item.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public void createItem(Item item) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
        }
    }

    @Override
    public void updateItem(Item item) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(item);
            transaction.commit();
        }
    }

    @Override
    public void deleteItem(Item item) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(item);
            transaction.commit();
        }
    }
}
