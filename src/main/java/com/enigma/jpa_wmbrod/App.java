package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();


        entityManager.close();
        JpaUtil.shutdown();
    }
}