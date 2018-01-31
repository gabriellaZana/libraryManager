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
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void persistEntity(Object object) {
        logger.info("");
        createTransaction();

        entityTransaction.begin();
        entityManager.persist(object);
        entityTransaction.commit();

        closeTransaction();
    }

    public static void mergeEntity(Object object) {
        createTransaction();

        entityTransaction.begin();
        entityManager.merge(object);
        entityTransaction.commit();

        closeTransaction();
    }

    public static void removeEntity(Object object) {
        createTransaction();

        entityTransaction.begin();
        entityManager.remove(object);
        entityTransaction.commit();

        closeTransaction();
    }

    private static void closeTransaction() {
        entityManager.close();
    }

    private static void createTransaction() {
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

}
