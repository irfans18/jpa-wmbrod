package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.entity.MMenuPrice;
import com.enigma.jpa_wmbrod.repository.AddColumnPriceWeekend;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AddColumnPriceRepositoryImpl implements AddColumnPriceWeekend {
    private final EntityManager entityManager;

    public AddColumnPriceRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addColumnPriceWeekend(List<MMenuPrice> prices) {
        entityManager.getTransaction().begin();
        prices.forEach(
                price -> {
                    price.setPriceWeekend(price.getPrice() * 1.5F);
                    entityManager.merge(price);
                }
        );
        entityManager.getTransaction().commit();
    }

    @Override
    public List<MMenuPrice> getAll() {
        return entityManager.createQuery("FROM MMenuPrice", MMenuPrice.class).getResultList();
    }
}
