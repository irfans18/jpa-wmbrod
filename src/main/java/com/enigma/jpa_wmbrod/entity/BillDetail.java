package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_detail_seq")
    @SequenceGenerator(name = "bill_detail_seq", sequenceName = "t_bill_detail_seq", allocationSize = 1)
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bill_id")
    private Bill bills;
    @ManyToOne
    @JoinColumn(name = "menu_price_id")
    private MMenuPrice menuPrices;
    @Column(name = "qty")
    private Integer qty;

    public BillDetail(Integer id, Bill bills, MMenuPrice menuPrices, Integer qty) {
        this.id = id;
        this.bills = bills;
        this.menuPrices = menuPrices;
        this.qty = qty;
    }

    public BillDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bill getBills() {
        return bills;
    }

    public void setBills(Bill bills) {
        this.bills = bills;
    }

    public MMenuPrice getMenuPrices() {
        return menuPrices;
    }

    public void setMenuPrices(MMenuPrice menuPrices) {
        this.menuPrices = menuPrices;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
