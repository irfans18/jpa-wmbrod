package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.entity.Bill;

import java.util.List;

public interface BillRepository {
    void save(Bill bill);
    List<Bill> findAll();
}
