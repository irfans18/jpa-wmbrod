package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.entity.MMenuPrice;

import java.util.List;

public interface AddColumnPriceWeekend {
    void addColumnPriceWeekend(List<MMenuPrice> prices);
    List<MMenuPrice> getAll();
}
