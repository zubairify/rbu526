package com.rbu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbu.entity.Product;
import com.rbu.exception.InvalidProductException;
import com.rbu.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product save(Product p) {
		return repo.save(p);
	}

	@Override
	public Product findByCode(int code) throws InvalidProductException {
		return repo.findById(code).orElseThrow(() -> new InvalidProductException(
										"Product not found with code: " + code));
	}

	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public List<Product> findByPriceRange(double min, double max) {
		return repo.findByPriceRange(min, max);
	}
}
