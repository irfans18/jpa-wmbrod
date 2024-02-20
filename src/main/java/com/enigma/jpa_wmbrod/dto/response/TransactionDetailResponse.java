package com.enigma.jpa_wmbrod.dto.response;

import com.enigma.jpa_wmbrod.entity.BillDetail;

import java.util.Date;
import java.util.List;

public class TransactionDetailResponse {
    private Long billId;
    private List<Long> billDetailId;
    private String customerName;
    private Date date;
    private String transType;
    private List<BillDetail> billDetails;

    public TransactionDetailResponse() {
    }

    public TransactionDetailResponse(Long billId, List<Long> billDetailId, String customerName, Date date, String transType, List<BillDetail> billDetails) {
        this.billId = billId;
        this.billDetailId = billDetailId;
        this.customerName = customerName;
        this.date = date;
        this.transType = transType;
        this.billDetails = billDetails;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public List<Long> getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(List<Long> billDetailId) {
        this.billDetailId = billDetailId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
