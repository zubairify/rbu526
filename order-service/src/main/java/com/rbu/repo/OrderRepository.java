package com.rbu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbu.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCustId(int cid);
}

