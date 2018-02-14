package com.threelittlepigs.codecool.libraryManager.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EntityUtility {

    private static final Logger logger = LoggerFactory.getLogger(EntityUtility.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libraryPU");


    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction entityTransaction;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void persistEntity(Object object) {
        logger.info("Persisting object : " + object.getClass().getSimpleName());

        createTransaction();
        entityTransaction.begin();
        entityManager.persist(object);
        entityTransaction.commit();
    }

    public static void mergeEntity(Object object) {
        logger.info("Merging object : " + object.getClass().getSimpleName());

        createTransaction();
        entityTransaction.begin();
        entityManager.merge(object);
        entityTransaction.commit();
    }

    public static void removeEntity(Object object) {
        logger.info("Removing object : " + object.getClass().getSimpleName());

        createTransaction();
        entityTransaction.begin();
        entityManager.remove(object);
        entityTransaction.commit();
    }

    private static void createTransaction() {
        entityTransaction = entityManager.getTransaction();
    }

    public static List likeByOneCriteria(Class c, String columnTitle, String columnValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(c);
        Root bk = cq.from(c);
        cq.select(bk)
                .where(cb.like(bk.get(columnTitle), columnValue));
        TypedQuery query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Deprecated
    public static List findByOneCriteria(Class c, String columnTitle, String columnValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(c);
        Root bk = cq.from(c);
        cq.select(bk)
                .where(cb.equal(bk.get(columnTitle), columnValue));
        TypedQuery query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public static List findByCriterias(Class c, List<String> columnTitles, List<String> columnValues) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(c);
        List<Predicate> predicates = new ArrayList<>();
        Root bk = cq.from(c);
        if (columnTitles.size() == columnValues.size()) {
            for (int i = 0; i < columnTitles.size(); i++) {
                predicates.add(cb.equal(bk.get(columnTitles.get(i)), columnValues.get(i)));
            }
        }
        cq.select(bk).where(cb.and(predicates.toArray(new Predicate[]{})));
        Query query = entityManager.createQuery(cq);
        System.out.println(query.getResultList());
        return query.getResultList();
    }
}
