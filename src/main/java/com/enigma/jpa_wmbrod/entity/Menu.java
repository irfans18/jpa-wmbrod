package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu", schema = "public", catalog = "wmbrod")
public class Menu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;
    @OneToMany(mappedBy = "mMenuByMenuId")
    private Collection<MenuPrice> mMenuPricesById;

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

    public Collection<MenuPrice> getmMenuPricesById() {
        return mMenuPricesById;
    }

    public void setmMenuPricesById(Collection<MenuPrice> mMenuPricesById) {
        this.mMenuPricesById = mMenuPricesById;
    }
}
