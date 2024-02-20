package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_menu_price")
public class MenuPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @Column(name = "price")
    private Float price;
    @Column(name = "price_weekend")
    private Float priceWeekend;
    @OneToMany(mappedBy = "menuPrice", cascade = CascadeType.PERSIST)
    private List<BillDetail> billDetail;

    public MenuPrice() {
    }

    public MenuPrice(Integer id, Menu menu) {
        this.id = id;
        this.menu = menu;
    }

    public MenuPrice(Menu menu) {
        this.menu = menu;
    }

    public MenuPrice(Integer id, Menu menu, Float price) {
        this.id = id;
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice(Menu menu, Float price) {
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice(Integer id, Float price) {
        this.id = id;
        this.price = price;
    }

    public MenuPrice(List<BillDetail> billDetail) {
        this.billDetail = billDetail;
    }

    public MenuPrice(Integer id, Menu menu, Float price, Float priceWeekend, List<BillDetail> billDetail) {
        this.id = id;
        this.menu = menu;
        this.price = price;
        this.priceWeekend = priceWeekend;
        this.billDetail = billDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public List<BillDetail> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(List<BillDetail> billDetail) {
        this.billDetail = billDetail;
    }
}
