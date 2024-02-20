package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "m_customer_discount", schema = "public", catalog = "wmbrod")
public class MCustomerDiscount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "disc_id", nullable = true)
    private Long discId;
    @Basic
    @Column(name = "customer_id", nullable = true)
    private Long customerId;
    @ManyToOne
    @JoinColumn(name = "disc_id", referencedColumnName = "id")
    private MDiscount mDiscountByDiscId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private MCustomer mCustomerByCustomerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDiscId() {
        return discId;
    }

    public void setDiscId(Long discId) {
        this.discId = discId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MCustomerDiscount that = (MCustomerDiscount) o;
        return id == that.id && Objects.equals(discId, that.discId) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discId, customerId);
    }

    public MDiscount getmDiscountByDiscId() {
        return mDiscountByDiscId;
    }

    public void setmDiscountByDiscId(MDiscount mDiscountByDiscId) {
        this.mDiscountByDiscId = mDiscountByDiscId;
    }

    public MCustomer getmCustomerByCustomerId() {
        return mCustomerByCustomerId;
    }

    public void setmCustomerByCustomerId(MCustomer mCustomerByCustomerId) {
        this.mCustomerByCustomerId = mCustomerByCustomerId;
    }
}
