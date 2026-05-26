package com.rbu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbu.dto.OrderDTO;
import com.rbu.entity.Customer;
import com.rbu.entity.Order;
import com.rbu.entity.Product;
import com.rbu.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private ProductService prodService;
	
	@Override
	public Order save(OrderDTO dto) {
		Order order = new Order();
		order.setOrdDate(LocalDate.now());
		
		double amt = 0;
		Customer cust = custService.findById(dto.getCid());
		List<Product> products = new ArrayList<Product>();
		for(int code : dto.getPcodes()) {
			Product p = prodService.findByCode(code);
			products.add(p);
			amt += p.getPrice();
		}
		
		order.setAmount(amt);
		order.setCust(cust);
		order.setItems(products);
		return repo.save(order);
	}

	@Override
	public Order findByNo(int ordNo) {
		return repo.findById(ordNo).get();
	}

	@Override
	public List<Order> findByCustomer(int cid) {
		return repo.findByCustomer(cid);
	}
}
