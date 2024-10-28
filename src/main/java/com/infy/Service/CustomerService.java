package com.infy.Service;

import org.springframework.stereotype.Service;

import com.infy.Entity.Customer;

@Service
public interface CustomerService {
	//register customer
	public String register(Customer customer);
	
	//login customer
	public Customer login(String email ,String password);
}
