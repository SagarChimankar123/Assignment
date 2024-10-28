package com.infy.Controller;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Entity.Customer;
import com.infy.Service.CustomerServiceImpl;
import com.infy.dao.Login;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
   // private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	
	
	@Autowired
	CustomerServiceImpl customerservice;
	
	@Tag(name="Registration")
	@PostMapping("register")
	public ResponseEntity<String> registration(@RequestBody Customer customer){
		log.info("Register API call from CustomerController");
		
		String massage=customerservice.register(customer);
		
		return new ResponseEntity<>(massage,HttpStatus.OK);
	}
	
	@Tag(name="User Login")
	@PostMapping("/login")
	public ResponseEntity<Customer> login(@RequestBody Login login ){
		log.info("Login Api call CustomerController");
		Customer c = customerservice.login(login.getCustEmail(), login.getCustPassword());
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
		 
		
	}
	
	

}
