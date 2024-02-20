package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_detail_seq")
    @SequenceGenerator(name = "bill_detail_seq", sequenceName = "t_bill_detail_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menu_price_id")
    private MenuPrice menuPrice;
    @Column(name = "qty")
    private Float qty;

    public BillDetail() {
    }

    public BillDetail(MenuPrice menuPrice, Float qty) {
        this.menuPrice = menuPrice;
        this.qty = qty;
    }

    public BillDetail(Long id, Bill billId, MenuPrice menuPrice, Float qty) {
        this.id = id;
        this.billId = billId;
        this.menuPrice = menuPrice;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public MenuPrice getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(MenuPrice menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }
}
