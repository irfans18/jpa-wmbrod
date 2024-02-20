package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_customer", schema = "public", catalog = "wmbrod")
public class MCustomer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;
    @Basic
    @Column(name = "mobile_phone_no", nullable = false, length = 20)
    private String mobilePhoneNo;
    @Basic
    @Column(name = "is_member", nullable = true)
    private Boolean isMember;
    @Basic
    @Column(name = "user_credential_id", nullable = true)
    private Integer userCredentialId;
    @OneToMany(mappedBy = "mCustomerByCustomerId")
    private Collection<MCustomerDiscount> mCustomerDiscountsById;
    @OneToMany(mappedBy = "mCustomerByCustomerId")
    private Collection<TBill> tBillsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Boolean getMember() {
        return isMember;
    }

    public void setMember(Boolean member) {
        isMember = member;
    }

    public Integer getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(Integer userCredentialId) {
        this.userCredentialId = userCredentialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MCustomer mCustomer = (MCustomer) o;
        return id == mCustomer.id && Objects.equals(customerName, mCustomer.customerName) && Objects.equals(mobilePhoneNo, mCustomer.mobilePhoneNo) && Objects.equals(isMember, mCustomer.isMember) && Objects.equals(userCredentialId, mCustomer.userCredentialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, mobilePhoneNo, isMember, userCredentialId);
    }

    public Collection<MCustomerDiscount> getmCustomerDiscountsById() {
        return mCustomerDiscountsById;
    }

    public void setmCustomerDiscountsById(Collection<MCustomerDiscount> mCustomerDiscountsById) {
        this.mCustomerDiscountsById = mCustomerDiscountsById;
    }

    public Collection<TBill> gettBillsById() {
        return tBillsById;
    }

    public void settBillsById(Collection<TBill> tBillsById) {
        this.tBillsById = tBillsById;
    }
}
