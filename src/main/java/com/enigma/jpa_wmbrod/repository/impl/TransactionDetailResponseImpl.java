package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;
import com.enigma.jpa_wmbrod.entity.*;
import com.enigma.jpa_wmbrod.repository.TransactionDetailRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class TransactionDetailResponseImpl implements TransactionDetailRepository {
    private final EntityManager entityManager;

    public TransactionDetailResponseImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(TransactionDetailRequest transactionDetailRequest) {
        entityManager.getTransaction().begin();
        TableMenu tableMenu = entityManager.find(TableMenu.class, transactionDetailRequest.getTableId());
        TransType transType = entityManager.find(TransType.class, transactionDetailRequest.getTransType());
        Bill bill = new Bill();
        bill.setCustomer(new Customer(transactionDetailRequest.getName()));
        bill.setDate(transactionDetailRequest.getDate());
        bill.setTableMenu(tableMenu);
        bill.setTransType(transType);
        List<BillDetail> billDetails = transactionDetailRequest.getBillDetails();
        billDetails.forEach(id -> {
            id.setBillId(bill);
        });

        entityManager.persist(bill);
        entityManager.getTransaction().commit();
    }

    @Override
    public TransactionDetailResponse findById(Integer id) {
        Bill bill = entityManager.find(Bill.class, id);
        List<BillDetail> billDetails = bill.getBillDetails();
        TransactionDetailResponse transactionDetailResponse = new TransactionDetailResponse();
        transactionDetailResponse.setBillId(bill.getId());
        transactionDetailResponse.setBillDetailId(billDetails.stream().map(BillDetail::getId).toList());
        transactionDetailResponse.setCustomerName(bill.getCustomer().getName());
        transactionDetailResponse.setDate(bill.getDate());
        transactionDetailResponse.setTransType(bill.getTransType().getDescription());
        transactionDetailResponse.setBillDetails(billDetails);
        return transactionDetailResponse;
    }

    @Override
    public TransactionDetailResponse getAll() {
        return null;
    }
}
