package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_bill_detail", schema = "public", catalog = "wmbrod")
public class TBillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_detail_seq")
    @SequenceGenerator(name = "bill_detail_seq", sequenceName = "t_bill_detail_seq", allocationSize = 1)
    private Long id;
    @Basic
    @Column(name = "qty", nullable = false, precision = 0)
    private Float qty;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    private TBill tBillByBillId;
    @ManyToOne
    @JoinColumn(name = "menu_price_id", referencedColumnName = "id", nullable = false)
    private MMenuPrice mMenuPriceByMenuPriceId;

    public TBillDetail() {
    }

    public TBillDetail(Long id, Float qty, TBill tBillByBillId, MMenuPrice mMenuPriceByMenuPriceId) {
        this.id = id;
        this.qty = qty;
        this.tBillByBillId = tBillByBillId;
        this.mMenuPriceByMenuPriceId = mMenuPriceByMenuPriceId;
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

    public TBill gettBillByBillId() {
        return tBillByBillId;
    }

    public void settBillByBillId(TBill tBillByBillId) {
        this.tBillByBillId = tBillByBillId;
    }

    public MMenuPrice getmMenuPriceByMenuPriceId() {
        return mMenuPriceByMenuPriceId;
    }

    public void setmMenuPriceByMenuPriceId(MMenuPrice mMenuPriceByMenuPriceId) {
        this.mMenuPriceByMenuPriceId = mMenuPriceByMenuPriceId;
    }
}
