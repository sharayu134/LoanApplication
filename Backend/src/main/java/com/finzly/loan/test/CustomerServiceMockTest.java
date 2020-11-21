package com.finzly.loan.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finzly.loan.dao.CustomerRepository;
import com.finzly.loan.model.Customer;
import com.finzly.loan.service.CustomerService;

class CustomerServiceMockTest {
		
	@org.junit.jupiter.api.Test
	void testGetCustomerById() {
		
		CustomerRepository customerRepository = mock(CustomerRepository.class);
		Customer mockCustomer =new Customer(10001,"password");
		mockCustomer.getCustomerId();
		mockCustomer.getPassword();
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.debug(mockCustomer.toString());
		
		Customer expectedCustomer =new Customer();
		expectedCustomer.setCustomerId(10001);
		expectedCustomer.setPassword("password");
		when(customerRepository.findById(10001)).thenReturn(Optional.of(mockCustomer));
		CustomerService customerService= new CustomerService(customerRepository);
		Customer actaulCustomer =customerService.get(10001);

		assertEquals(expectedCustomer, actaulCustomer);
	}
	
}
