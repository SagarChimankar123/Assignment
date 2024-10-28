package com.infy.Service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infy.Entity.Customer;
import com.infy.Repository.CustomerRepo;
import com.infy.dao.Login;
import com.infy.exception.ApiError;
import com.infy.exception.LoginExcep;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo cRepo;

	@Override
	public String register(Customer customer) {
		cRepo.save(customer);
		return "Register Sucessfully";
	}

	@Override
	public Customer login(String email, String password)  {
		log.info("login method called from CustomerServiceImpl");
		
		Customer customer=cRepo.findByCustEmailAndCustPassword(email, password);
		if(customer==null) {
			throw new LoginExcep("Login Failed");
		}
		return customer;
	}
	
}
