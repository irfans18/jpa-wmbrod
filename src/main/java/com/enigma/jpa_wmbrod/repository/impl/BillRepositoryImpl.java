package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.entity.Bill;
import com.enigma.jpa_wmbrod.repository.BillRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BillRepositoryImpl implements BillRepository {
    private EntityManager em;

    public BillRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Bill bill) {

    }

    @Override
    public List<Bill> findAll() {
        return em.createQuery("FROM Bill").getResultList();
    }
}
