package com.ivanvelev.repositories;

import com.ivanvelev.models.Country;
import com.ivanvelev.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
