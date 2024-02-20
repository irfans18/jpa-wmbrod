package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "m_menu", schema = "public", catalog = "wmbrod")
public class Menu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "menu_name")
    private String menuName;
    @OneToMany(mappedBy = "menuByMenuId")
    private List<MenuPrice> menuPricesById;

    public Menu(Long id, String menuName) {
        this.id = id;
        this.menuName = menuName;
    }

    public Menu() {
    }

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(menuName, menu.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuName);
    }

    public List<MenuPrice> getmMenuPricesById() {
        return menuPricesById;
    }

    public void setmMenuPricesById(List<MenuPrice> menuPricesById) {
        this.menuPricesById = menuPricesById;
    }
}
