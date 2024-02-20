package com.enigma.jpa_wmbrod.dto.response;

import java.time.LocalDate;
import java.util.Date;

public class TransactionDetailPerDateResponse {
    private Date transDate;
    private String customerName;
    private Float total;

    public TransactionDetailPerDateResponse(Date transDate, String customerName, Float total) {
        this.transDate = transDate;
        this.customerName = customerName;
        this.total = total;
    }

    public TransactionDetailPerDateResponse(String customerName, Float total) {
        this.customerName = customerName;
        this.total = total;
    }

    public TransactionDetailPerDateResponse() {
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TransactionDetailPerDateResponse{" +
                "transDate=" + transDate +
                ", customerName='" + customerName + '\'' +
                ", total=" + total +
                '}';
    }
}
