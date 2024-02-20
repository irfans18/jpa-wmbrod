package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu_price", schema = "public", catalog = "wmbrod")
public class MenuPrice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false, precision = 0)
    private Float price;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private Menu mMenuByMenuId;
    @OneToMany(mappedBy = "mMenuPriceByMenuPriceId")
    private Collection<BillDetail> tBillDetailsById;

    public MenuPrice() {
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

    public Menu getmMenuByMenuId() {
        return mMenuByMenuId;
    }

    public void setmMenuByMenuId(Menu mMenuByMenuId) {
        this.mMenuByMenuId = mMenuByMenuId;
    }

    public Collection<BillDetail> gettBillDetailsById() {
        return tBillDetailsById;
    }

    public void settBillDetailsById(Collection<BillDetail> tBillDetailsById) {
        this.tBillDetailsById = tBillDetailsById;
    }
}
