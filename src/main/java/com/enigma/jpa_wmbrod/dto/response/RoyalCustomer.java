package com.enigma.jpa_wmbrod.dto.response;

import com.enigma.jpa_wmbrod.entity.BillDetail;

import java.util.Date;
import java.util.List;

public class RoyalCustomer {
    private String name;
    private Date date;
    private List<BillDetail> billDetailList;
    private Float totalTransactionBuy;

    public RoyalCustomer() {
    }

    public RoyalCustomer(String name, Date date, List<BillDetail> billDetailList, Float totalTransactionBuy) {
        this.name = name;
        this.date = date;
        this.billDetailList = billDetailList;
        this.totalTransactionBuy = totalTransactionBuy;
    }

    public RoyalCustomer(String name, List<BillDetail> billDetailList, Float totalTransactionBuy) {
        this.name = name;
        this.billDetailList = billDetailList;
        this.totalTransactionBuy = totalTransactionBuy;
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

    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    public Float getTotalTransactionBuy() {
        return totalTransactionBuy;
    }

    public void setTotalTransactionBuy(Float totalTransactionBuy) {
        this.totalTransactionBuy = totalTransactionBuy;
    }
}
