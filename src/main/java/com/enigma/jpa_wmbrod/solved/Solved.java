package com.enigma.jpa_wmbrod.solved;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.GetOmsetWeekend;
import com.enigma.jpa_wmbrod.dto.response.GetTotalOmset;
import com.enigma.jpa_wmbrod.dto.response.RoyalCustomer;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;
import com.enigma.jpa_wmbrod.entity.Bill;
import com.enigma.jpa_wmbrod.entity.BillDetail;
import com.enigma.jpa_wmbrod.entity.MenuPrice;
import com.enigma.jpa_wmbrod.repository.AddColumnPriceWeekend;
import com.enigma.jpa_wmbrod.repository.TransactionDetailRepository;
import com.enigma.jpa_wmbrod.repository.impl.AddColumnPriceRepositoryImpl;
import com.enigma.jpa_wmbrod.repository.impl.TransactionDetailResponseImpl;
import jakarta.persistence.EntityManager;
import org.hibernate.grammars.hql.HqlParser;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Solved {
    // 1. Total Omset di WMBROD
    public void getTotalOmset(EntityManager entityManager) {
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        GetTotalOmset totalOmset = transactionDetailRepository.getTotalOmset();
        System.out.println("Total Omset di wmbrod: " + totalOmset.getTotal());
    }


    // 2. Customer paling royal per transdate
    public void getRoyalCustomer(EntityManager entityManager) {
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        List<RoyalCustomer> royalCustomer = transactionDetailRepository.getRoyalCustomer();
        royalCustomer.forEach(
                customer -> {
                    System.out.printf("%-10s | %-10s | %s \n", customer.getDate(), customer.getName(), customer.getTotalTransactionBuy());
                }
        );
    }


    // 3. Total omset di wmb pas weekend (pakai hari biasa)
    public void getNormalPriceWeekend(EntityManager entityManager) {
        getTotalOmsetOnWeekend(entityManager, true);
    }

    public void addColumnPriceWeekend(EntityManager entityManager) {
        AddColumnPriceWeekend addColumnPriceWeekend = new AddColumnPriceRepositoryImpl(entityManager);
        //        get menu price list
        List<MenuPrice> allPrices = addColumnPriceWeekend.getAll();
//        create query to add column in menu_price with float type
        addColumnPriceWeekend.addColumnPriceWeekend(allPrices);
    }

    // 4.
    //    Masukkan data transaksi berikut :
    //    Nama: Budi Tanggal Transaksi: 17 February 2024 Meja: 4 Jenis Transaksi: Makan Ditempat Menu yang dipesan:
    //    Nasi Putih 1x
    //    Nasi Goreng 1x
    //    Sayur Sop 1x
    //    Es Ovaltine 1x
    //    Nama: Budi Tanggal Transaksi: 18 February 2024 Meja: 2 Jenis Transaksi: Makan Ditempat Menu yang dipesan:
    //    Indomie Goreng Telor 1x
    //    Telor Balado 2x
    //    Kopi Kapal Api 1x

    public void addTransDetail(EntityManager entityManager, String dateBuy, List<BillDetail> billDetails, String name, Integer tableId, String transType) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(dateBuy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TransactionDetailRequest transactionDetailRequest = new TransactionDetailRequest(
                name,
                date,
                tableId,
                transType,
                billDetails
        );
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        transactionDetailRepository.save(transactionDetailRequest);
    }

    // 5.
    public void getTotalOmsetOnWeekend(EntityManager entityManager, Boolean isNormalPrice) {
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        GetOmsetWeekend omsetOnWeekend = transactionDetailRepository.getOmsetOnWeekend(isNormalPrice);
        if (omsetOnWeekend != null) {
            System.out.println("Total Transaksi Hari Sabtu: " + omsetOnWeekend.getTotalTransactionSaturday());
            System.out.println("Total Transaksi Hari Minggu: " + omsetOnWeekend.getTotalTransactionSunday());
        } else {
            System.out.println("Tidak ada transaksi pada hari Sabtu dan Minggu");
        }
    }

    // 6. additional
    public void getId(EntityManager entityManager, Integer id) {
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        TransactionDetailResponse byId = transactionDetailRepository.findById(id);
        System.out.println("Bill ID: " + byId.getBillId());
        System.out.println("Nama: " + byId.getCustomerName());
        System.out.println("Tanggal Transaksi: " + byId.getDate());
        System.out.println("Tipe Transaksi: " + byId.getTransType());
        byId.getBillDetails().forEach(
                billDetail -> {
                    System.out.printf("%-50s | %dx \n", billDetail.getMenuPrice().getMenu().getName(), billDetail.getQty().intValue());
                }
        );
    }
}
