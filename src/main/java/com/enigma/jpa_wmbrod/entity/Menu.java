package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "menu_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.PERSIST)
    private List<MenuPrice> menuPrices;

    public Menu() {
    }

    public Menu(Long id, String name, List<MenuPrice> menuPrices) {
        this.id = id;
        this.name = name;
        this.menuPrices = menuPrices;
    }

    public Menu(Long id, String name) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
