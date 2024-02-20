package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_trans_type")
public class TransType {
    @Id
    @Column(name = "trans_type_id")
    private String id;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "transType", cascade = CascadeType.PERSIST)
    private List<Bill> bills;

    public TransType() {
    }

    public TransType(String description) {
        this.description = description;
    }

    public TransType(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public TransType(String id, String description, List<Bill> bills) {
        this.id = id;
        this.description = description;
        this.bills = bills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
