package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu_price", schema = "public", catalog = "wmbrod")
public class MenuPrice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "price")
    private Float price;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private Menu menuByMenuId;
    @OneToMany(mappedBy = "menuPriceByMenuPriceId")
    private Collection<BillDetail> billDetailsById;

    public MenuPrice() {
    }

    public MenuPrice(Menu menu, Float price) {
        this.menuByMenuId = menu;
        this.price = price;
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
        return menuByMenuId;
    }

    public void setmMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }

    public Collection<BillDetail> gettBillDetailsById() {
        return billDetailsById;
    }

    public void settBillDetailsById(Collection<BillDetail> billDetailsById) {
        this.billDetailsById = billDetailsById;
    }
}
