package com.enigma.jpa_wmbrod.repository;


import com.enigma.jpa_wmbrod.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(Integer id);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(Customer customer);
}
