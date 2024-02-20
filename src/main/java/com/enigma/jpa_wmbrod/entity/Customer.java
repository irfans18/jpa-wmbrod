package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_customer", schema = "public", catalog = "wmbrod")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "mobile_phone_no")
    private String mobilePhoneNo;
    @Column(name = "is_member")
    private Boolean isMember;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<MCustomerDiscount> mCustomerDiscountsById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Bill> billsById;

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

    public Collection<MCustomerDiscount> getmCustomerDiscountsById() {
        return mCustomerDiscountsById;
    }

    public void setmCustomerDiscountsById(Collection<MCustomerDiscount> mCustomerDiscountsById) {
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }

    public Collection<Bill> gettBillsById() {
        return billsById;
    }

    public void settBillsById(Collection<Bill> billsById) {
        this.billsById = billsById;
    }
}
