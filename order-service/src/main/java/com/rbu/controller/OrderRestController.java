package com.rbu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.entity.Order;
import com.rbu.service.OrderService;
import com.rbu.vo.OrderVO;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

	@Autowired
	private OrderService service;
	
	@PostMapping	// http://localhost:9003/api/v1/orders
	public ResponseEntity<OrderVO> save(@RequestBody Order order) {
		OrderVO resp = service.save(order);
		return new ResponseEntity<OrderVO>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{no}")	// http://localhost:9003/api/v1/orders/1
	public ResponseEntity<OrderVO> findByNo(@PathVariable int no) {
		OrderVO resp = service.findByNo(no);
		return new ResponseEntity<OrderVO>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{cid}")	// http://localhost:9003/api/v1/orders/customer/123
	public ResponseEntity<List<OrderVO>> findByCustomer(@PathVariable int cid) {
		List<OrderVO> resp = service.findByCustomer(cid);
		return new ResponseEntity<List<OrderVO>>(resp, HttpStatus.FOUND);
	}
}
