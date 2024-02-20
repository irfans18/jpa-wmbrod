package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "m_customer_discount", schema = "public", catalog = "wmbrod")
public class MCustomerDiscount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "disc_id", referencedColumnName = "id")
    private MDiscount mDiscountByDiscId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerByCustomerId;

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

    public Customer getmCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setmCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
