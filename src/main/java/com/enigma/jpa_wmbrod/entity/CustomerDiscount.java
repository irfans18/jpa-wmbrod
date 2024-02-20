package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "m_customer_discount", schema = "public", catalog = "wmbrod")
public class CustomerDiscount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "disc_id", nullable = true)
    private Discount mDiscountByDiscId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerByCustomerId;

    public CustomerDiscount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discount getmDiscountByDiscId() {
        return mDiscountByDiscId;
    }

    public void setmDiscountByDiscId(Discount mDiscountByDiscId) {
        this.mDiscountByDiscId = mDiscountByDiscId;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
