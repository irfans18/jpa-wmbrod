package com.enigma.jpa_wmbrod.repository;


import com.enigma.jpa_wmbrod.dto.request.MenuInfoRequest;

public interface MenuDetailRepository {
    void save(MenuInfoRequest request);
}
