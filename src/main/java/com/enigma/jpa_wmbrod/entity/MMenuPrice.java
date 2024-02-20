package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu_price")
public class MMenuPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_price_seq")
    @SequenceGenerator(name = "menu_price_seq", sequenceName = "m_menu_price_id_seq", allocationSize = 1)
    private Integer id;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private Float price;
    @Basic
    @Column(name = "price_weekend")
    private Float priceWeekend;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private MMenu mMenuByMenuId;
    @OneToMany(mappedBy = "mMenuPriceByMenuPriceId")
    private Collection<TBillDetail> tBillDetailsById;

    public MMenuPrice() {
    }

    public MMenuPrice(Integer id, Float price, Float priceWeekend, MMenu mMenuByMenuId, Collection<TBillDetail> tBillDetailsById) {
        this.id = id;
        this.price = price;
        this.priceWeekend = priceWeekend;
        this.mMenuByMenuId = mMenuByMenuId;
        this.tBillDetailsById = tBillDetailsById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPriceWeekend() {
        return priceWeekend;
    }

    public void setPriceWeekend(Float priceWeekend) {
        this.priceWeekend = priceWeekend;
    }

    public MMenu getmMenuByMenuId() {
        return mMenuByMenuId;
    }

    public void setmMenuByMenuId(MMenu mMenuByMenuId) {
        this.mMenuByMenuId = mMenuByMenuId;
    }

    public Collection<TBillDetail> gettBillDetailsById() {
        return tBillDetailsById;
    }

    public void settBillDetailsById(Collection<TBillDetail> tBillDetailsById) {
        this.tBillDetailsById = tBillDetailsById;
    }
}
