package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "t_bill_detail")
public class BillDetail {
    @Id
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne()
    @JoinColumn(name = "menu_price_id")
    private MenuPrice menuPrice;


    @Column(name = "qty")
    private Float qty;


    public BillDetail(Integer id, Float qty, Bill bill) {
        this.id = id;
        this.qty = qty;
        this.bill = bill;
    }

    public BillDetail() {
    }

    public BillDetail(Integer id, Bill bill, MenuPrice menuPrice, Float qty) {
        this.id = id;
        this.bill = bill;
        this.menuPrice = menuPrice;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", bill=" + bill +
                ", menuPriceId=" + menuPrice +
                ", qty=" + qty +
                '}';
    }
}
