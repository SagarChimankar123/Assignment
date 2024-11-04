package com.infy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.Entity.Customer;
import com.infy.Repository.CustomerRepo;
import com.infy.Service.CustomerServiceImpl;
import com.infy.dao.Login;

@SpringBootTest
@AutoConfigureMockMvc
public class chakeRegisterMethod {
	
	@Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        Customer customer = new Customer();
        customer.setCustId(1);
		customer.setCustName("ram");
		customer.setCustEmail("rampatil@gmail.com");
		customer.setCustPassword("ram@123");

        when(cRepo.save(customer)).thenReturn(customer);

        String result = customerService.register(customer);

        assertEquals("Register Sucessfully", result);
        //verify(cRepo, times(1)).save(customer);
    }
    
}
