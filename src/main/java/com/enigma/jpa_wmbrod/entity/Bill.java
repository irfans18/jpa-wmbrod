package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "t_bill")
public class Bill {
    @Id
    private Integer id;

    @Column(name = "trans_date")
    private Date transDate;

    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "table_id")
    private Integer tableId;
    @Column(name = "trans_type")
    private String transType;

    public Bill(Integer id, Date transDate, Integer customerId, Integer tableId, String transType) {
        this.id = id;
        this.transDate = transDate;
        this.customerId = customerId;
        this.tableId = tableId;
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

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "TBill{" +
                "id=" + id +
                ", transDate=" + transDate +
                ", customerId=" + customerId +
                ", tableId=" + tableId +
                ", transType='" + transType + '\'' +
                '}';
    }
}
