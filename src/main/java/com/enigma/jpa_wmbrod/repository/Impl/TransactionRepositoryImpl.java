package com.enigma.jpa_wmbrod.repository.Impl;

import com.enigma.jpa_wmbrod.dto.response.TransactionDetailPerDateResponse;
import com.enigma.jpa_wmbrod.repository.TransactionRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private EntityManager entityManager;

    public TransactionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TransactionDetailPerDateResponse> findAll() {

        String nativeQuery = "SELECT DISTINCT ON (b.trans_date) b.trans_date, " +
                "c.customer_name, " +
                "SUM(bd.qty * mp.price) AS total " +
                "FROM t_bill b " +
                "JOIN m_customer c " +
                "ON b.customer_id = c.id " +
                "Join t_bill_detail bd " +
                "ON bd.bill_id = b.id " +
                "JOIN m_menu_price mp " +
                "ON mp.id = bd.menu_price_id " +
                "GROUP BY b.trans_date, c.customer_name " +
                "ORDER BY b.trans_date, total DESC";

        List<Object[]> resultList = entityManager.createNativeQuery(nativeQuery).getResultList();

        List<TransactionDetailPerDateResponse> responseList = new ArrayList<>();
        for (Object[] row : resultList) {
            Date transDate = (Date) row[0];
            String customerName = (String) row[1];
            Float total = (Float) row[2];

            responseList.add(new TransactionDetailPerDateResponse(transDate, customerName, total));
        }

        return responseList;
    }
}
