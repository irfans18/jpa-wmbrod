package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "m_menu_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "menu_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST})
    private List<MenuPrice> menuPrices;

    public Menu(Integer id, String name, List<MenuPrice> menuPrices) {
        this.id = id;
        this.name = name;
        this.menuPrices = menuPrices;
    }

    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, List<MenuPrice> menuPrices) {
        this.name = name;
        this.menuPrices = menuPrices;
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuPrice> getMenuPrices() {
        return menuPrices;
    }

    public void setMenuPrices(List<MenuPrice> menuPrices) {
        this.menuPrices = menuPrices;
    }
}
