package com.rbu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rbu.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("FROM Order WHERE cust.custId=:cid")
	List<Order> findByCustomer(int cid);
}

