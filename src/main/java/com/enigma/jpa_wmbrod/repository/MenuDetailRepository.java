package com.enigma.jpa_wmbrod.repository;


import com.enigma.jpa_wmbrod.request.MenuInfoRequest;

public interface MenuDetailRepository {
    void save(MenuInfoRequest request);
}
