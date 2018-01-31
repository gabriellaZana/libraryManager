package com.threelittlepigs.codecool.libraryManager.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityUtility {
    private static final Logger logger = LoggerFactory.getLogger(EntityUtility.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libraryPU");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static EntityTransaction entityTransaction;

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

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
