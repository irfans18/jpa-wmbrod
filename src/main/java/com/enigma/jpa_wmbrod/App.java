package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.entity.MMenuPrice;
import com.enigma.jpa_wmbrod.repository.AddColumnPriceWeekend;
import com.enigma.jpa_wmbrod.repository.impl.AddColumnPriceRepositoryImpl;
import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        AddColumnPriceWeekend addColumnPriceWeekend = new AddColumnPriceRepositoryImpl(entityManager);

        addPriceWeekend(addColumnPriceWeekend);

        entityManager.close();
        JpaUtil.shutdown();
    }

    private static void addPriceWeekend(AddColumnPriceWeekend addColumnPriceWeekend) {
        //        get menu price list
        List<MMenuPrice> allPrices = addColumnPriceWeekend.getAll();
//        create query to add column in menu_price with float type
        addColumnPriceWeekend.addColumnPriceWeekend(allPrices);
    }
}