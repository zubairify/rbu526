package com.rbu.service;

import java.util.List;

import com.rbu.dto.OrderDTO;
import com.rbu.entity.Order;

public interface OrderService {

	Order save(OrderDTO dto);
	
	Order findByNo(int ordNo);
	
	List<Order> findByCustomer(int cid);
}
