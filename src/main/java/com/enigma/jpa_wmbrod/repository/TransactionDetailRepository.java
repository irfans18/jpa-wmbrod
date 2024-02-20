package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;

public interface TransactionDetailRepository {
    void save(TransactionDetailRequest transactionDetailRequest);
    TransactionDetailResponse findById(Integer id);
    TransactionDetailResponse getAll();
}
