package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_trans_type", schema = "public", catalog = "wmbrod")
public class TransType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "trans_type_id")
    private String transTypeId;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "transTypeByTransType")
    private Collection<Bill> billsByTransTypeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransType that = (TransType) o;
        return Objects.equals(transTypeId, that.transTypeId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transTypeId, description);
    }

    public Collection<Bill> gettBillsByTransTypeId() {
        return billsByTransTypeId;
    }

    public void settBillsByTransTypeId(Collection<Bill> billsByTransTypeId) {
        this.billsByTransTypeId = billsByTransTypeId;
    }
}
