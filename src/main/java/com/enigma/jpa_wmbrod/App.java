package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
        entityManager.close();
        JpaUtil.shutdown();
    }
}