package com.enigma.jpa_wmbrod.entity;

import com.enigma.jpa_wmbrod.entity.MCustomer;
import com.enigma.jpa_wmbrod.entity.MTable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_seq")
    @SequenceGenerator(name = "bill_seq", sequenceName = "t_bill_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "trans_date")
    private LocalDate transDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private MCustomer customers;
    @ManyToOne
    @JoinColumn(name = "table_id")
    private MTable tables;
    private String transType;

    public Bill(Integer id, LocalDate transDate, MCustomer customers, MTable tables, String transType) {
        this.id = id;
        this.transDate = transDate;
        this.customers = customers;
        this.tables = tables;
        this.transType = transType;
    }

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public MCustomer getCustomers() {
        return customers;
    }

    public void setCustomers(MCustomer customers) {
        this.customers = customers;
    }

    public MTable getTables() {
        return tables;
    }

    public void setTables(MTable tables) {
        this.tables = tables;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }
}
