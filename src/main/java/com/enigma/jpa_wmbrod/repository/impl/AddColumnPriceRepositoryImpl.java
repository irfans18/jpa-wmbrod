package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.entity.MenuPrice;
import com.enigma.jpa_wmbrod.repository.AddColumnPriceWeekend;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AddColumnPriceRepositoryImpl implements AddColumnPriceWeekend {
    private final EntityManager entityManager;

    public AddColumnPriceRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addColumnPriceWeekend(List<MenuPrice> prices) {
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
    public List<MenuPrice> getAll() {
        return entityManager.createQuery("FROM MenuPrice", MenuPrice.class).getResultList();
    }
}
