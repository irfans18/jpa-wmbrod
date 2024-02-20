package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "m_customer_discount")
public class MCustomerDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_discount_seq")
    @SequenceGenerator(name = "customer_discount_seq", sequenceName = "m_customer_discount_seq", allocationSize = 1)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "disc_id", referencedColumnName = "id")
    private MDiscount mDiscountByDiscId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private MCustomer mCustomerByCustomerId;

    public MCustomerDiscount() {
    }

    public MCustomerDiscount(Integer id, MDiscount mDiscountByDiscId, MCustomer mCustomerByCustomerId) {
        this.id = id;
        this.mDiscountByDiscId = mDiscountByDiscId;
        this.mCustomerByCustomerId = mCustomerByCustomerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
