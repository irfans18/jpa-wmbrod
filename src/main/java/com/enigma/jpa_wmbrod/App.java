package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.dto.response.TransactionDetailPerDateResponse;
import com.enigma.jpa_wmbrod.repository.Impl.TransactionRepositoryImpl;
import com.enigma.jpa_wmbrod.repository.TransactionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        TransactionRepository transactionRepository = new TransactionRepositoryImpl(entityManager);
        List<TransactionDetailPerDateResponse> result = transactionRepository.findAll();

        for (TransactionDetailPerDateResponse response : result) {
            System.out.println("Transaction Date: " + response.getTransDate());
            System.out.println("Customer Name: " + response.getCustomerName());
            System.out.println("Subtotal: " + response.getTotal());
            System.out.println("---------------------");
        }

        transaction.commit();

        entityManager.close();
        JpaUtil.shutdown();
    }
}