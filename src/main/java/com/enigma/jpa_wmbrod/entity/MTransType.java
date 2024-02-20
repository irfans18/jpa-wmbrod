package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_trans_type", schema = "public", catalog = "wmbrod")
public class MTransType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "trans_type_id", nullable = false, length = 3)
    private String transTypeId;
    @Basic
    @Column(name = "description", nullable = true, length = 50)
    private String description;
    @OneToMany(mappedBy = "mTransTypeByTransType")
    private Collection<TBill> tBillsByTransTypeId;

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
        MTransType that = (MTransType) o;
        return Objects.equals(transTypeId, that.transTypeId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transTypeId, description);
    }

    public Collection<TBill> gettBillsByTransTypeId() {
        return tBillsByTransTypeId;
    }

    public void settBillsByTransTypeId(Collection<TBill> tBillsByTransTypeId) {
        this.tBillsByTransTypeId = tBillsByTransTypeId;
    }
}
