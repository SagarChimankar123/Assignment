package com.infy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.infy.Entity.Customer;
import com.infy.Service.CustomerService;
import com.infy.Service.CustomerServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerService;

	@Test
	public void testRegistrationSuccess() throws Exception {
		Customer customer = new Customer();
		customer.setCustId(1);
		customer.setCustName("ram");
		customer.setCustEmail("rampatil@gmail.com");
		customer.setCustPassword("ram@123");

		when(customerService.register(Mockito.any(Customer.class))).thenReturn("Register Sucessfully");

		String result = customerService.register(customer);
		
		//assertEquals(result, "Register Sucessfully");
		
		
	}

	@Test
	public void testLoginSuccess() throws Exception {
		Customer customer = new Customer();
		customer.setCustEmail("sagar@gmail.com");
		customer.setCustPassword("sagar@123");

		when(customerService.login(Mockito.anyString(), Mockito.anyString())).thenReturn(customer);

	}

}
