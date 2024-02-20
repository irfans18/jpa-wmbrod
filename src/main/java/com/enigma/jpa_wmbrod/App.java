package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.util.JpaUtil;
import com.enigma.jpa_wmbrod.view.TotalAgregatView;
import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TotalAgregatView totalAgregatView = new TotalAgregatView(entityManager);
        totalAgregatView.getTotalTrx();

        entityManager.close();
        JpaUtil.shutdown();
    }
}