package com.ivanvelev.repositories;

import com.ivanvelev.models.Review;
import com.ivanvelev.utils.SessionUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    @Override
    public List<Review> getAllReviews() {
        try (Session session = SessionUtil.getSession()) {
            Query<Review> query = session.createQuery("from review ", Review.class);
            return query.getResultList();
        }
    }

    @Override
    public Review getReviewById(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query<Review> query = session.createQuery("from review r where r.id=:id", Review.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    @Transactional
    public void createReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(review);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void updateReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(review);
            transaction.commit();
        }
    }

    @Override
    @Transactional
    public void deleteReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(review);
            transaction.commit();
        }
    }
}
