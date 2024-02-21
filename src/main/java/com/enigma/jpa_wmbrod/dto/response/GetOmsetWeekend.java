package com.enigma.jpa_wmbrod.dto.response;

public class GetOmsetWeekend {
    private Float totalTransactionSaturday;
    private Float totalTransactionSunday;

    public GetOmsetWeekend() {
    }

    public GetOmsetWeekend(Float totalTransactionSaturday, Float totalTransactionSunday) {
        this.totalTransactionSaturday = totalTransactionSaturday;
        this.totalTransactionSunday = totalTransactionSunday;
    }

    public Float getTotalTransactionSaturday() {
        return totalTransactionSaturday;
    }

    public void setTotalTransactionSaturday(Float totalTransactionSaturday) {
        this.totalTransactionSaturday = totalTransactionSaturday;
    }

    public Float getTotalTransactionSunday() {
        return totalTransactionSunday;
    }

    public void setTotalTransactionSunday(Float totalTransactionSunday) {
        this.totalTransactionSunday = totalTransactionSunday;
    }
}
