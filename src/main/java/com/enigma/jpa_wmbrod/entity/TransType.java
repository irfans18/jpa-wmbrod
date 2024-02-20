package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_trans_type", schema = "public", catalog = "wmbrod")
public class TransType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "trans_type_id", nullable = false, length = 3)
    private String transTypeId;
    @Column(name = "description", nullable = true, length = 50)
    private String description;
    @OneToMany(mappedBy = "mTransTypeByTransType")
    private Collection<Bill> tBillsByTransTypeId;

    public TransType() {
    }

    public String getTransTypeId() {
        return transTypeId;
    }

    public void setTransTypeId(String transTypeId) {
        this.transTypeId = transTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Bill> gettBillsByTransTypeId() {
        return tBillsByTransTypeId;
    }

    public void settBillsByTransTypeId(Collection<Bill> tBillsByTransTypeId) {
        this.tBillsByTransTypeId = tBillsByTransTypeId;
    }
}
