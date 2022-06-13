package com.ivanvelev.repositories;

import com.ivanvelev.models.Address;
import com.ivanvelev.models.Country;
import com.ivanvelev.util.SessionUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository{

    @Override
    public List<Address> getAllAddresses() {
        try (Session session = SessionUtil.getSession()) {
            Query<Address> query = session.createQuery("from address ", Address.class);
            return query.getResultList();
        }
    }

    @Override
    public Address getAddressById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Address> query = session.createQuery("from address a where a.id=:id", Address.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    @Transactional
    public void createAddress(Address address) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(address.getCountry());
            session.persist(address);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void deleteAddress(Address address) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(address);
            transaction.commit();
        }
    }
}
