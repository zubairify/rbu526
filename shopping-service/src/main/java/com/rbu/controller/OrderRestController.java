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

import com.rbu.dto.OrderDTO;
import com.rbu.entity.Order;
import com.rbu.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody OrderDTO dto) {
		Order resp = service.save(dto);
		return new ResponseEntity<Order>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<Order> findByNo(@PathVariable int no) {
		Order resp = service.findByNo(no);
		return new ResponseEntity<Order>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{cid}")
	public ResponseEntity<List<Order>> findByCustomer(@PathVariable int cid) {
		List<Order> resp = service.findByCustomer(cid);
		return new ResponseEntity<List<Order>>(resp, HttpStatus.FOUND);
	}
}
