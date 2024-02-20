package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "m_customer_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "mobile_phone_no")
    private String phoneNumber;
    @Column(name = "is_member")
    private Boolean isMember;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Bill> bills;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Integer id, String name, String phoneNumber, Boolean isMember) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isMember = isMember;
    }

    //    constructor with userCredential


    public Customer(Integer id, String name, String phoneNumber, Boolean isMember, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isMember = isMember;
        this.bills = bills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getMember() {
        return isMember;
    }

    public void setMember(Boolean member) {
        isMember = member;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
