package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.dto.response.TransactionDetailPerDateResponse;

import java.util.List;

public interface TransactionRepository {
    List<TransactionDetailPerDateResponse> findAll();
}
