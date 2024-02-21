package com.enigma.jpa_wmbrod.dto.response;

public class GetTotalOmset {
    private Float price;
    private Float qty;
    private Float total;

    public GetTotalOmset() {
    }

    public GetTotalOmset(Float price, Float qty) {
        this.price = price;
        this.qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
