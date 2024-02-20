package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_customer", schema = "public", catalog = "wmbrod")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;
    @Column(name = "mobile_phone_no", nullable = false, length = 20)
    private String mobilePhoneNo;
    @Column(name = "is_member", nullable = true)
    private Boolean isMember;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<CustomerDiscount> mCustomerDiscountsById;
    @OneToMany(mappedBy = "mCustomerByCustomerId")
    private Collection<Bill> tBillsById;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean member) {
        isMember = member;
    }

    public Collection<CustomerDiscount> getmCustomerDiscountsById() {
        return mCustomerDiscountsById;
    }

    public void setmCustomerDiscountsById(Collection<CustomerDiscount> mCustomerDiscountsById) {
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }

    public Collection<Bill> gettBillsById() {
        return tBillsById;
    }

    public void settBillsById(Collection<Bill> tBillsById) {
        this.tBillsById = tBillsById;
    }
}
