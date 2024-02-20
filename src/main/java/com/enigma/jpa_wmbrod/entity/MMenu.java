package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu")
public class MMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "m_menu_seq", allocationSize = 1)
    private Long id;
    @Basic
    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;
    @OneToMany(mappedBy = "mMenuByMenuId")
    private Collection<MMenuPrice> mMenuPricesById;

    public MMenu() {
    }

    public MMenu(Long id, String menuName, Collection<MMenuPrice> mMenuPricesById) {
        this.id = id;
        this.menuName = menuName;
        this.mMenuPricesById = mMenuPricesById;
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

    public Collection<MMenuPrice> getmMenuPricesById() {
        return mMenuPricesById;
    }

    public void setmMenuPricesById(Collection<MMenuPrice> mMenuPricesById) {
        this.mMenuPricesById = mMenuPricesById;
    }
}
