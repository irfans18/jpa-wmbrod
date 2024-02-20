package com.enigma.jpa_wmbrod.repository.Impl;

import com.enigma.jpa_wmbrod.dto.response.TransactionDetailPerDateResponse;
import com.enigma.jpa_wmbrod.repository.TransactionRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private EntityManager entityManager;

    public TransactionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<TransactionDetailPerDateResponse> findAll() {
        return entityManager
                .createQuery("SELECT NEW com.enigma.jpa_wmbrod.dto.response.TransactionDetailPerDateResponse(DISTINCT (b.transDate), c.customerName, SUM(bd.qty * mp.price)) " +
                                "FROM TBillDetail bd " +
                                "JOIN bd.tBillByBillId b " +
                                "JOIN b.mCustomerByCustomerId c " +
                                "JOIN bd.mMenuPriceByMenuPriceId mp " +
                                "GROUP BY b.transDate, c.customerName " +
                                "ORDER BY b.transDate, SUM(bd.qty * mp.price) DESC",
                        TransactionDetailPerDateResponse.class)
                .getResultList();
    }
}
