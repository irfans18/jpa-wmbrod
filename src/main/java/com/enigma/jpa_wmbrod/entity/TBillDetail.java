package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_bill_detail", schema = "public", catalog = "wmbrod")
public class TBillDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "bill_id", nullable = false)
    private long billId;
    @Basic
    @Column(name = "menu_price_id", nullable = false)
    private int menuPriceId;
    @Basic
    @Column(name = "qty", nullable = false, precision = 0)
    private float qty;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    private TBill tBillByBillId;
    @ManyToOne
    @JoinColumn(name = "menu_price_id", referencedColumnName = "id", nullable = false)
    private MMenuPrice mMenuPriceByMenuPriceId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public int getMenuPriceId() {
        return menuPriceId;
    }

    public void setMenuPriceId(int menuPriceId) {
        this.menuPriceId = menuPriceId;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBillDetail that = (TBillDetail) o;
        return id == that.id && billId == that.billId && menuPriceId == that.menuPriceId && Float.compare(qty, that.qty) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, menuPriceId, qty);
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
