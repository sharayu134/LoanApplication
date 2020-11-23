package com.finzly.loan.rest;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.finzly.loan.model.Customer;
import com.finzly.loan.rest.CustomerController;
import com.finzly.loan.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void testCustomerController() throws Exception {
		
		Customer customer=new Customer(10001,"passsword");

		when(customerService.get(10001)).thenReturn(customer);
		this.mockMvc.perform(get("/customers/10001")).andDo(print()).andExpect(status().isOk());
	}
}

