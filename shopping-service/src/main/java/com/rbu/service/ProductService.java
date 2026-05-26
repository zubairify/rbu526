package com.rbu.service;

import java.util.List;

import com.rbu.entity.Product;
import com.rbu.exception.InvalidProductException;

public interface ProductService {

	Product save(Product p);
	
	Product findByCode(int code) throws InvalidProductException;
	
	List<Product> listAll();
	
	List<Product> findByPriceRange(double min, double max);
}
