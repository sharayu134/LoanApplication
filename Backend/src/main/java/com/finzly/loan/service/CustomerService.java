package com.finzly.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.loan.dao.CustomerRepository;
import com.finzly.loan.model.Customer;



/**
 * @author USER
 *This is Customer Service class
 */
@Service
public class CustomerService { 
	CustomerService(){}
	
	@Autowired
	private CustomerRepository customerRepository;
	
public CustomerService(CustomerRepository customerRepository2) {
	this.customerRepository=customerRepository2;	}

	public Customer get(Integer customerId) {
		return customerRepository.findById(customerId).get();
	}

}
