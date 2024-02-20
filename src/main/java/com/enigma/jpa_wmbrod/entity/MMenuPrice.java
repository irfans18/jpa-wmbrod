package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu_price", schema = "public", catalog = "wmbrod")
public class MMenuPrice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "menu_id", nullable = false)
    private long menuId;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private float price;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private MMenu mMenuByMenuId;
    @OneToMany(mappedBy = "mMenuPriceByMenuPriceId")
    private Collection<TBillDetail> tBillDetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMenuPrice that = (MMenuPrice) o;
        return id == that.id && menuId == that.menuId && Float.compare(price, that.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuId, price);
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
