package com.enigma.jpa_wmbrod.repository;

import com.enigma.jpa_wmbrod.entity.MenuPrice;

import java.util.List;

public interface AddColumnPriceWeekend {
    void addColumnPriceWeekend(List<MenuPrice> prices);
    List<MenuPrice> getAll();
}
