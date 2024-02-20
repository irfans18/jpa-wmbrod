package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_table", schema = "public", catalog = "wmbrod")
public class MTable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "table_name", nullable = false, length = 3)
    private String tableName;
    @OneToMany(mappedBy = "mTableByTableId")
    private Collection<TBill> tBillsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTable mTable = (MTable) o;
        return id == mTable.id && Objects.equals(tableName, mTable.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableName);
    }

    public Collection<TBill> gettBillsById() {
        return tBillsById;
    }

    public void settBillsById(Collection<TBill> tBillsById) {
        this.tBillsById = tBillsById;
    }
}
