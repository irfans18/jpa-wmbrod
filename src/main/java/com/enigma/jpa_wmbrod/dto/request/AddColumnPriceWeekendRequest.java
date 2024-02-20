package com.enigma.jpa_wmbrod.dto.request;

public class AddColumnPriceWeekendRequest {

    private Float priceWeekend;

    public AddColumnPriceWeekendRequest() {
    }

    public AddColumnPriceWeekendRequest(Float priceWeekend) {
        this.priceWeekend = priceWeekend;
    }

    public Float getPriceWeekend() {
        return priceWeekend;
    }

    public void setPriceWeekend(Float priceWeekend) {
        this.priceWeekend = priceWeekend;
    }
}
