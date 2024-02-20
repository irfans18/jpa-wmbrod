package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_menu_price")
public class MenuPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_price_seq")
    @SequenceGenerator(name = "menu_price_seq", sequenceName = "m_menu_price_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "price", nullable = false)
    private Float price;

    public MenuPrice(Integer id, Menu menu, Float price) {
        this.id = id;
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice(Integer id, Float price) {
        this.id = id;
        this.price = price;
    }

    public MenuPrice(Menu menu, Float price) {
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice() {
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

    @Override
    public String toString() {
        return "MenuPrice{" +
                "id=" + id +
                ", menu=" + menu +
                ", price=" + price +
                '}';
    }
}
