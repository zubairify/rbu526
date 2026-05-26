package com.rbu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.entity.Customer;
import com.rbu.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService service;
	
	@PostMapping(consumes = "application/json")	// http://localhost:8080/api/v1/customers
	public ResponseEntity<Customer> save(@RequestBody Customer c) {
		Customer resp = service.save(c);
		return new ResponseEntity<Customer>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")	// http://localhost:8080/v1/api/customers/123
	public ResponseEntity<Customer> findById(@PathVariable("id") int cid) {
		Customer resp = service.findById(cid);
		return new ResponseEntity<Customer>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping		// http://localhost:8080/v1/api/customers
	public ResponseEntity<List<Customer>> listAll() {
		List<Customer> list = service.listAll();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.FOUND);
	}
	
	@GetMapping("/cell")	// http://localhost:8080/v1/api/customers/cell?mobile=34349239
	public ResponseEntity<Customer> findByMobile(@RequestParam String mobile) {
		Customer resp = service.findByMobile(mobile);
		return new ResponseEntity<Customer>(resp, HttpStatus.FOUND);
	}
}
