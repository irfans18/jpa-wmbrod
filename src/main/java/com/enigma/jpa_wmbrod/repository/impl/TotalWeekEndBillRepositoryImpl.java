package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.dto.response.TotalWeekEndBill;
import com.enigma.jpa_wmbrod.repository.TotalWeekEndBillRepository;
import jakarta.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TotalWeekEndBillRepositoryImpl implements TotalWeekEndBillRepository {
    EntityManager entityManager;

    public TotalWeekEndBillRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void weekendBill() {
        List<TotalWeekEndBill> resultSaturday = new ArrayList<>();
        List<TotalWeekEndBill> resultSunday = new ArrayList<>();

        List<Object[]> billDetails = entityManager.createQuery(
                        "SELECT b.transDate, SUM(mp.price * bd.qty) " +
                                "FROM BillDetail AS bd " +
                                "JOIN bd.bill AS b " +
                                "JOIN bd.menuPrice AS mp " +
                                "GROUP BY b.transDate", Object[].class)
                .getResultList();


        for (Object[] billDetail : billDetails) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format((Date) billDetail[0]);
            try {
                Date date = sdf.parse(formattedDate);
                int day = date.getDay();
                if (day == 0) {
                    resultSunday.add(new TotalWeekEndBill((Date) billDetail[0], (Double) billDetail[1]));
                }
                if (day == 6) {
                    resultSaturday.add(new TotalWeekEndBill((Date) billDetail[0], (Double) billDetail[1]));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        resultSunday.forEach(e -> {
            System.out.println("Minggu");
            System.out.println(e.getDate());
            System.out.println("Rp " + (int) e.getPrice().doubleValue());
            System.out.println("-".repeat(20));
        });

        resultSaturday.forEach(e -> {
            System.out.println("Sabtu");
            System.out.println(e.getDate());
            System.out.println("Rp " + (int) e.getPrice().doubleValue());
            System.out.println("-".repeat(20));
        });

    }
}
