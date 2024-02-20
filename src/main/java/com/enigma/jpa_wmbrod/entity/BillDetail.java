package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_bill_detail", schema = "public", catalog = "wmbrod")
public class BillDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "qty")
    private Float qty;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    private Bill billByBillId;
    @ManyToOne
    @JoinColumn(name = "menu_price_id", referencedColumnName = "id", nullable = false)
    private MenuPrice menuPriceByMenuPriceId;

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
        return billByBillId;
    }

    public void settBillByBillId(Bill billByBillId) {
        this.billByBillId = billByBillId;
    }

    public MenuPrice getmMenuPriceByMenuPriceId() {
        return menuPriceByMenuPriceId;
    }

    public void setmMenuPriceByMenuPriceId(MenuPrice menuPriceByMenuPriceId) {
        this.menuPriceByMenuPriceId = menuPriceByMenuPriceId;
    }
}
