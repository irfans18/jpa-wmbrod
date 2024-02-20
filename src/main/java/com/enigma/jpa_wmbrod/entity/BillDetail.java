package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_bill_detail", schema = "public", catalog = "wmbrod")
public class BillDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "qty", nullable = false, precision = 0)
    private Float qty;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    private Bill tBillByBillId;
    @ManyToOne
    @JoinColumn(name = "menu_price_id", referencedColumnName = "id", nullable = false)
    private MenuPrice mMenuPriceByMenuPriceId;

    public BillDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Bill gettBillByBillId() {
        return tBillByBillId;
    }

    public void settBillByBillId(Bill tBillByBillId) {
        this.tBillByBillId = tBillByBillId;
    }

    public MenuPrice getmMenuPriceByMenuPriceId() {
        return mMenuPriceByMenuPriceId;
    }

    public void setmMenuPriceByMenuPriceId(MenuPrice mMenuPriceByMenuPriceId) {
        this.mMenuPriceByMenuPriceId = mMenuPriceByMenuPriceId;
    }
}
