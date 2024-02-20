package com.enigma.jpa_wmbrod.view;

import com.enigma.jpa_wmbrod.entity.Bill;
import com.enigma.jpa_wmbrod.repository.BillRepository;
import com.enigma.jpa_wmbrod.repository.impl.BillRepositoryImpl;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TotalAgregatView {
    private EntityManager em;

    public TotalAgregatView(EntityManager em) {
        this.em = em;
    }

    /**
     *  1. total transaksi di wmb */
    public void getTotalTrx(){
        BillRepository repository = new BillRepositoryImpl(em);
        List<Bill> bills = repository.findAll();
        System.out.println(bills);
    }
}
