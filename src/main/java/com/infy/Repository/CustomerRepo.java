package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public Customer findByCustEmailAndCustPassword(String email,String password);
}
