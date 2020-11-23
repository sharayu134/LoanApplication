package com.finzly.loan.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.finzly.loan.dao.CustomerRepository;
import com.finzly.loan.model.Customer;
import com.finzly.loan.service.CustomerService;

class CustomerServiceMockTest {
		
	@org.junit.jupiter.api.Test
	void testGetCustomerById() {
		
		CustomerRepository customerRepository = mock(CustomerRepository.class);
		Customer mockCustomer =new Customer(10001,"password");

		Customer expectedCustomer =new Customer(10001,"password");

		when(customerRepository.findById(10001)).thenReturn(Optional.of(mockCustomer));
		CustomerService customerService= new CustomerService(customerRepository);
		Customer actaulCustomer =customerService.get(10001);

		assertEquals(expectedCustomer, actaulCustomer);
	}
	
}
