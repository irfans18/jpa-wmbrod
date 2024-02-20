package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_discount")
public class MDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_discount_seq")
    @SequenceGenerator(name = "m_discount_seq", sequenceName = "m_id_discount_seq", allocationSize = 1)
    private Integer id;
    @Basic
    @Column(name = "disc_desciption", nullable = true, length = 50)
    private String discDesciption;
    @Basic
    @Column(name = "pct", nullable = true)
    private Integer pct;
    @OneToMany(mappedBy = "mDiscountByDiscId")
    private Collection<MCustomerDiscount> mCustomerDiscountsById;

    public MDiscount() {
    }

    public MDiscount(Integer id, String discDesciption, Integer pct, Collection<MCustomerDiscount> mCustomerDiscountsById) {
        this.id = id;
        this.discDesciption = discDesciption;
        this.pct = pct;
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
