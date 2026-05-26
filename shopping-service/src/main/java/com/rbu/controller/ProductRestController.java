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

import com.rbu.entity.Product;
import com.rbu.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	@PostMapping	// http://localhost:8080/v1/api/products
	public ResponseEntity<Product> save(@RequestBody Product p) {
		Product resp = service.save(p);
		return new ResponseEntity<Product>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{code}")	// http://localhost:8080/v1/api/products/101
	public ResponseEntity<Product> findByCode(@PathVariable int code) {
		Product resp = service.findByCode(code);
		return new ResponseEntity<Product>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping		// http://localhost:8080/v1/api/products
	public ResponseEntity<List<Product>> list() {
		List<Product> list = service.listAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
	}
	
	@GetMapping("/range")	// http://localhost:8080/v1/api/products/range?min=500&max=2000
	public ResponseEntity<List<Product>> listByPrice(@RequestParam double min, @RequestParam double max) {
		List<Product> list = service.findByPriceRange(min, max);
		return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
	}
}
