package com.rbu.service;

import java.util.List;

import com.rbu.entity.Customer;
import com.rbu.exception.InvalidCustomerException;

public interface CustomerService {

	Customer save(Customer c);
	
	Customer findById(int cid) throws InvalidCustomerException;
	
	List<Customer> listAll();
	
	Customer findByMobile(String mobile) throws InvalidCustomerException;
}
