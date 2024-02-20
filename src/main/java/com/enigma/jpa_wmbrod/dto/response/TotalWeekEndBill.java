package com.enigma.jpa_wmbrod.dto.response;

import java.util.Date;

public class TotalWeekEndBill {
    Date date;
    Double price;

    public TotalWeekEndBill(Date date, Double price) {
        this.date = date;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
