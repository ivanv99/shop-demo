package com.ivanvelev.repositories;

import com.ivanvelev.models.Country;
import com.ivanvelev.util.SessionUtil;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {

    @Override
    public List<Country> getAllCountries() {
        try (Session session = SessionUtil.getSession()) {
            Query<Country> query = session.createQuery("from country ", Country.class);
            return query.getResultList();
        }
    }

    @Override
    public Country getCountryById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Country> query = session.createQuery("from country c where c.id= :id ", Country.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }
}
