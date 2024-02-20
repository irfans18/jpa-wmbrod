package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_discount", schema = "public", catalog = "wmbrod")
public class MDiscount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "disc_desciption", nullable = true, length = 50)
    private String discDesciption;
    @Basic
    @Column(name = "pct", nullable = true)
    private Integer pct;
    @OneToMany(mappedBy = "mDiscountByDiscId")
    private Collection<MCustomerDiscount> mCustomerDiscountsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscDesciption() {
        return discDesciption;
    }

    public void setDiscDesciption(String discDesciption) {
        this.discDesciption = discDesciption;
    }

    public Integer getPct() {
        return pct;
    }

    public void setPct(Integer pct) {
        this.pct = pct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MDiscount mDiscount = (MDiscount) o;
        return id == mDiscount.id && Objects.equals(discDesciption, mDiscount.discDesciption) && Objects.equals(pct, mDiscount.pct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discDesciption, pct);
    }

    public Collection<MCustomerDiscount> getmCustomerDiscountsById() {
        return mCustomerDiscountsById;
    }

    public void setmCustomerDiscountsById(Collection<MCustomerDiscount> mCustomerDiscountsById) {
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }
}
