package com.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
