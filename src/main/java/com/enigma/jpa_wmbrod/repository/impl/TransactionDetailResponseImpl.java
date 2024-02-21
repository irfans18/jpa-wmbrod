package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.GetOmsetWeekend;
import com.enigma.jpa_wmbrod.dto.response.GetTotalOmset;
import com.enigma.jpa_wmbrod.dto.response.RoyalCustomer;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;
import com.enigma.jpa_wmbrod.entity.*;
import com.enigma.jpa_wmbrod.repository.TransactionDetailRepository;
import jakarta.persistence.EntityManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        bill.setDate(transactionDetailRequest.getDate());
        bill.setCustomer(new Customer(transactionDetailRequest.getName()));
        bill.setTableMenu(tableMenu);
        bill.setTransType(transType);

        transactionDetailRequest.getBillDetails().forEach(
                billDetailRequest -> {
                    Menu menu = entityManager.createQuery("FROM Menu WHERE name = :name", Menu.class)
                            .setParameter("name", billDetailRequest.getMenuPrice().getMenu().getName()).getSingleResult();
                    MenuPrice price = entityManager.find(MenuPrice.class, new MenuPrice(menu.getId().intValue(), menu).getId());
                    BillDetail billDetail = new BillDetail();
                    billDetail.setBillId(bill);
                    billDetail.setMenuPrice(price);
                    billDetail.setQty(billDetailRequest.getQty());
                    bill.getBillDetails().add(billDetail);
                }
        );

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
    public List<Bill> getAllBill() {
        return entityManager.createQuery("FROM Bill", Bill.class).getResultList();
    }

    @Override
    public GetOmsetWeekend getOmsetOnWeekend(boolean isNormalPrice) {
        String query = "SELECT * FROM t_bill WHERE EXTRACT(ISODOW FROM trans_date ) IN (";
        List<Bill> resultListOnSturday = entityManager
                .createNativeQuery(new StringBuilder().append(query).append("6)").toString(), Bill.class)
                .getResultList();
        List<Bill> resultListOnSunday = entityManager
                .createNativeQuery(new StringBuilder().append(query).append("7)").toString(), Bill.class)
                .getResultList();

        GetOmsetWeekend omsetWeekend = new GetOmsetWeekend();
        omsetWeekend.setTotalTransactionSaturday(getTransactionDetailWeekend(resultListOnSturday, isNormalPrice));
        omsetWeekend.setTotalTransactionSunday(getTransactionDetailWeekend(resultListOnSunday, isNormalPrice));
        return omsetWeekend;
    }

    private Float getTransactionDetailWeekend(List<Bill> resulstOnWeekend, boolean isNormalPrice) {
        if (isNormalPrice) {
            return resulstOnWeekend.stream()
                    .flatMap(omset -> omset.getBillDetails().stream())
                    .map(billDetail -> billDetail.getMenuPrice().getPrice() * billDetail.getQty())
                    .reduce(0F, Float::sum);
        } else {
            return resulstOnWeekend.stream()
                    .flatMap(omset -> omset.getBillDetails().stream())
                    .map(billDetail -> billDetail.getMenuPrice().getPriceWeekend() * billDetail.getQty())
                    .reduce(0F, Float::sum);
        }
    }

    @Override
    public GetTotalOmset getTotalOmset() {
        List<Bill> bills = entityManager.createQuery("FROM Bill", Bill.class).getResultList();
        GetTotalOmset totalOmset = new GetTotalOmset();
        totalOmset.setTotal(bills.stream()
                .flatMap(bill -> bill.getBillDetails().stream())
                .map(billDetail -> billDetail.getMenuPrice().getPrice() * billDetail.getQty())
                .reduce(0F, Float::sum));
        return totalOmset;
    }

    @Override
    public List<RoyalCustomer> getRoyalCustomer() {
        List<Bill> bills = entityManager.createQuery("FROM Bill", Bill.class).getResultList();
        List<RoyalCustomer> customersWithTotalOmset = bills.stream()
                .map(bill -> {
                    RoyalCustomer royalCustomer = new RoyalCustomer();
                    royalCustomer.setDate(bill.getDate());
                    royalCustomer.setName(bill.getCustomer().getName());
                    royalCustomer.setBillDetailList(bill.getBillDetails());
                    Float reduce = bill.getBillDetails().stream()
                            .map(billDetail -> billDetail.getMenuPrice().getPrice() * billDetail.getQty())
                            .reduce(0F, Float::sum);
                    royalCustomer.setTotalTransactionBuy(reduce);
                    return royalCustomer;
                }).toList();
        Map<Date, List<RoyalCustomer>> customersGroupByDate = customersWithTotalOmset.stream()
                .collect(Collectors.groupingBy(RoyalCustomer::getDate));
        Map<Date, RoyalCustomer> royalCustomerMap = customersGroupByDate.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .max(Comparator.comparing(RoyalCustomer::getTotalTransactionBuy)).orElse(null)
                ));
        return royalCustomerMap.values().stream().toList();
    }
}
