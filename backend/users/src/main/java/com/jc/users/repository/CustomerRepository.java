package com.jc.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.users.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUuid(String uuid);
    Optional<Customer> findByEmail(String email);
}