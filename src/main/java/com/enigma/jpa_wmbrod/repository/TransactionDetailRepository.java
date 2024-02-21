package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.GetOmsetWeekend;
import com.enigma.jpa_wmbrod.dto.response.GetTotalOmset;
import com.enigma.jpa_wmbrod.dto.response.RoyalCustomer;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;
import com.enigma.jpa_wmbrod.entity.Bill;

import java.util.List;

public interface TransactionDetailRepository {
    void save(TransactionDetailRequest transactionDetailRequest);
    TransactionDetailResponse findById(Integer id);
    List<Bill> getAllBill();
    GetOmsetWeekend getOmsetOnWeekend();
    GetTotalOmset getTotalOmset();
    List<RoyalCustomer> getRoyalCustomer();
}
