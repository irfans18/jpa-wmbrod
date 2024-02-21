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
import com.enigma.jpa_wmbrod.solved.Solved;
import com.enigma.jpa_wmbrod.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Solved solved = new Solved();

//        solved.addColumnPriceWeekend(entityManager);
//
//        solved.addTransDetail(entityManager, "17-02-2024", List.of(
//                new BillDetail(new MenuPrice(new Menu("Nasi Putih")), 1F),
//                new BillDetail(new MenuPrice(new Menu("Nasi Goreng")), 1F),
//                new BillDetail(new MenuPrice(new Menu("Sayur Sop")), 1F),
//                new BillDetail(new MenuPrice(new Menu("Es Ovaltine")), 1F)
//        ), "Budi", 4, "Makan Ditempat");
//        solved.addTransDetail(entityManager, "18-02-2024", List.of(
//                new BillDetail(new MenuPrice(new Menu("Indomie Goreng Telor")), 1F),
//                new BillDetail(new MenuPrice(new Menu("Telor Balado")), 2F),
//                new BillDetail(new MenuPrice(new Menu("Kopi Kapal Api")), 1F)
//        ), "Budi", 2, "Makan Ditempat");
//
//        solved.getId(entityManager, 118);
//        solved.getId(entityManager, 119);

//        weekend price
//        solved.getTotalOmsetOnWeekend(entityManager, false);

//        solved.getTotalOmset(entityManager);

//        solved.getRoyalCustomer(entityManager);

//        normal price on weekend
//        solved.getTotalOmsetOnWeekend(entityManager, true);

        entityManager.close();
        JpaUtil.shutdown();
    }

}