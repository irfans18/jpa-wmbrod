package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "m_table", schema = "public", catalog = "wmbrod")
public class MTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_seq")
    @SequenceGenerator(name = "table_seq", sequenceName = "m_table_seq", allocationSize = 1)
    private Integer id;
    @Basic
    @Column(name = "table_name", nullable = false, length = 3)
    private String tableName;
    @OneToMany(mappedBy = "mTableByTableId")
    private Collection<TBill> tBillsById;

    public MTable() {
    }

    public MTable(Integer id, String tableName, Collection<TBill> tBillsById) {
        this.id = id;
        this.tableName = tableName;
        this.tBillsById = tBillsById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Collection<TBill> gettBillsById() {
        return tBillsById;
    }

    public void settBillsById(Collection<TBill> tBillsById) {
        this.tBillsById = tBillsById;
    }
}
