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
    private Integer id;
    @Column(name = "table_name", nullable = false, length = 3)
    private String tableName;
    @OneToMany(mappedBy = "mTableByTableId")
    private Collection<Bill> tBillsById;

    public MTable() {
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

    public Collection<Bill> gettBillsById() {
        return tBillsById;
    }


    public void settBillsById(Collection<Bill> tBillsById) {
        this.tBillsById = tBillsById;
    }
}
