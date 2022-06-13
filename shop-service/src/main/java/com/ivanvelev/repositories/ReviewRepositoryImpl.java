package com.ivanvelev.repositories;

import com.ivanvelev.models.Review;
import com.ivanvelev.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository{

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
    public void createReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(review);
            transaction.commit();
        }
    }

    @Override
    public void updateReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(review);
            transaction.commit();
        }
    }

    @Override
    public void deleteReview(Review review) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(review);
            transaction.commit();
        }
    }
}
