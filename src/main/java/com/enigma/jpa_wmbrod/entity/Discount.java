package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_discount", schema = "public", catalog = "wmbrod")
public class Discount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "disc_desciption", nullable = true, length = 50)
    private String discDesciption;
    @Basic
    @Column(name = "pct", nullable = true)
    private Integer pct;
    @OneToMany(mappedBy = "mDiscountByDiscId")
    private Collection<CustomerDiscount> mCustomerDiscountsById;

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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Discount discount = (Discount) object;
        return Objects.equals(id, discount.id) && Objects.equals(discDesciption, discount.discDesciption) && Objects.equals(pct, discount.pct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discDesciption, pct);
    }

    public Collection<CustomerDiscount> getmCustomerDiscountsById() {
        return mCustomerDiscountsById;
    }

    public void setmCustomerDiscountsById(Collection<CustomerDiscount> mCustomerDiscountsById) {
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }
}
