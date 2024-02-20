package com.enigma.jpa_wmbrod.repository.impl;

import com.enigma.jpa_wmbrod.entity.Customer;
import com.enigma.jpa_wmbrod.repository.CustomerRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Customer object) {
        entityManager.getTransaction().begin();

        entityManager.persist(object);

        entityManager.getTransaction().commit();
    }

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer ").getResultList();
    }

    @Override
    public void update(Customer object) {
        entityManager.getTransaction().begin();

        entityManager.merge(object);

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Customer object) {
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, object.getId());
        entityManager.remove(customer);

        entityManager.getTransaction().commit();
    }
}
