package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_menu", schema = "public", catalog = "wmbrod")
public class MMenu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;
    @OneToMany(mappedBy = "mMenuByMenuId")
    private Collection<MMenuPrice> mMenuPricesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        MMenu mMenu = (MMenu) o;
        return id == mMenu.id && Objects.equals(menuName, mMenu.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuName);
    }

    public Collection<MMenuPrice> getmMenuPricesById() {
        return mMenuPricesById;
    }

    public void setmMenuPricesById(Collection<MMenuPrice> mMenuPricesById) {
        this.mMenuPricesById = mMenuPricesById;
    }
}
