package com.rbu.service;

import java.util.List;

import com.rbu.entity.Order;
import com.rbu.vo.OrderVO;

public interface OrderService {

	OrderVO save(Order order);
	
	OrderVO findByNo(int ordNo);
	
	List<OrderVO> findByCustomer(int cid);
}
