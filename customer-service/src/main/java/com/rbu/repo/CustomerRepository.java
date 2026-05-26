package com.rbu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbu.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByMobile(String mobile);
}
