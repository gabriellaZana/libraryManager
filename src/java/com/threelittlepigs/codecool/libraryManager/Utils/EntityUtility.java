package com.threelittlepigs.codecool.libraryManager.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityUtility {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libraryPU");
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;


    public static void persistEntity(Object object) {
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
