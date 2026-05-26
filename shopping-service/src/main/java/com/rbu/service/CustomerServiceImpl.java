package com.rbu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbu.entity.Customer;
import com.rbu.exception.InvalidCustomerException;
import com.rbu.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer save(Customer c) {
		return repo.save(c);
	}

	@Override
	public Customer findById(int cid) throws InvalidCustomerException {
		return repo.findById(cid).orElseThrow(() -> new InvalidCustomerException(
											"Customer not found with Id:" + cid));
	}

	@Override
	public List<Customer> listAll() {
		return repo.findAll();
	}

	@Override
	public Customer findByMobile(String mobile) throws InvalidCustomerException {
		Customer c = repo.findByMobile(mobile);
		if(c == null)
			throw new InvalidCustomerException("Customer not found with mobile no " + mobile);
		return c;
	}
}
