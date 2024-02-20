package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.entity.Menu;
import com.enigma.jpa_wmbrod.entity.MenuPrice;
import com.enigma.jpa_wmbrod.repository.MenuDetailRepository;
import com.enigma.jpa_wmbrod.request.MenuInfoRequest;
import jakarta.persistence.EntityManager;

public class MenuDetailRepositoryImpl implements MenuDetailRepository {
    private EntityManager em;

    public MenuDetailRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(MenuInfoRequest request) {
        em.getTransaction().begin();

        MenuPrice menuPrice = new MenuPrice(new Menu(request.getName()), request.getPrice());
        em.persist(menuPrice);

        em.getTransaction().commit();
    }
}
