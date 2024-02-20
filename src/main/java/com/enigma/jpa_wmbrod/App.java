package com.enigma.jpa_wmbrod;

import com.enigma.jpa_wmbrod.dto.request.TransactionDetailRequest;
import com.enigma.jpa_wmbrod.dto.response.TransactionDetailResponse;
import com.enigma.jpa_wmbrod.entity.BillDetail;
import com.enigma.jpa_wmbrod.entity.Menu;
import com.enigma.jpa_wmbrod.entity.MenuPrice;
import com.enigma.jpa_wmbrod.repository.AddColumnPriceWeekend;
import com.enigma.jpa_wmbrod.repository.TransactionDetailRepository;
import com.enigma.jpa_wmbrod.repository.impl.AddColumnPriceRepositoryImpl;
import com.enigma.jpa_wmbrod.repository.impl.TransactionDetailResponseImpl;
import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        /*

        Masukkan data transaksi berikut :
        Nama: Budi Tanggal Transaksi: 17 February 2024 Meja: 4 Jenis Transaksi: Makan Ditempat Menu yang dipesan:
        Nasi Putih 1x
        Nasi Goreng 1x
        Sayur Sop 1x
        Es Ovaltine 1x
        Nama: Budi Tanggal Transaksi: 18 February 2024 Meja: 2 Jenis Transaksi: Makan Ditempat Menu yang dipesan:
        Indomie Goreng Telor 1x
        Telor Balado 2x
        Kopi Kapal Api 1x

*/
//        addColumnPriceWeekend(entityManager);

        addTransDetail(entityManager, "17-02-2024", List.of(
                new BillDetail(new MenuPrice(new Menu("Nasi Putih")), 1F),
                new BillDetail(new MenuPrice(new Menu("Nasi Goreng")), 1F),
                new BillDetail(new MenuPrice(new Menu("Sayur Sop")), 1F),
                new BillDetail(new MenuPrice(new Menu("Es Ovaltine")), 1F)
        ), 4, "EI");

        addTransDetail(entityManager, "18-02-2024", List.of(
                new BillDetail(new MenuPrice(new Menu("Indomie Goreng Telor")), 1F),
                new BillDetail(new MenuPrice(new Menu("Telor Balado")), 2F),
                new BillDetail(new MenuPrice(new Menu("Kopi Kapal Api")), 1F)
        ), 2, "EI");

//        getId(entityManager, 99);
//        getId(entityManager, 100);

        entityManager.close();
        JpaUtil.shutdown();
    }

    private static void addColumnPriceWeekend(EntityManager entityManager) {
        AddColumnPriceWeekend addColumnPriceWeekend = new AddColumnPriceRepositoryImpl(entityManager);
        //        get menu price list
        List<MenuPrice> allPrices = addColumnPriceWeekend.getAll();
//        create query to add column in menu_price with float type
        addColumnPriceWeekend.addColumnPriceWeekend(allPrices);
    }

    private static void getId(EntityManager entityManager, Integer id) {
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

    private static void addTransDetail(EntityManager entityManager, String dateBuy, List<BillDetail> billDetails, Integer tableId, String transType) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(dateBuy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TransactionDetailRequest transactionDetailRequest = new TransactionDetailRequest(
                "Budi",
                date,
                tableId,
                transType,
                billDetails
        );
        TransactionDetailRepository transactionDetailRepository = new TransactionDetailResponseImpl(entityManager);
        transactionDetailRepository.save(transactionDetailRequest);
    }


}