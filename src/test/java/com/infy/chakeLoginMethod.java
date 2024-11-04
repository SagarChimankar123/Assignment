package com.infy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.infy.Entity.Customer;
import com.infy.Repository.CustomerRepo;
import com.infy.Service.CustomerServiceImpl;
import com.infy.exception.LoginExcep;

public class chakeLoginMethod {
	@Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setCustEmail("sagar@gmail.com");
        customer.setCustPassword("sagar@123");
    }

    @Test
    public void testLoginSuccess() {
        when(cRepo.findByCustEmailAndCustPassword("sagar@gmail.com", "sagar@123")).thenReturn(customer);

        Customer result = customerService.login("sagar@gmail.com", "sagar@123");

        assertNotNull(result);
        assertEquals("sagar@gmail.com", result.getCustEmail());
    }

    @Test
    public void testLoginFailure() {
        when(cRepo.findByCustEmailAndCustPassword("sagar@gmail.com", "sagar@123")).thenReturn(null);

        assertThrows(LoginExcep.class, () -> {
            customerService.login("sagar@gmail.com", "sagar@123");
        });
    }

    

    

}
