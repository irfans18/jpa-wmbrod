package com.enigma.jpa_wmbrod.dto.request;

import com.enigma.jpa_wmbrod.entity.BillDetail;

import java.util.Date;
import java.util.List;

public class TransactionDetailRequest {
    private String name;
    private Date date;
    private Integer tableId;
    private String transType;
    private List<BillDetail> billDetails;

    public TransactionDetailRequest() {
    }

    public TransactionDetailRequest(String name, Date date, Integer tableId, String transType, List<BillDetail> billDetails) {
        this.name = name;
        this.date = date;
        this.tableId = tableId;
        this.transType = transType;
        this.billDetails = billDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
