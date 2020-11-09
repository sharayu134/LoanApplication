package com.finzly.loan.service;

import java.util.List;

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
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> listAll(){
		return customerRepository.findAll();
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer get(Integer customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	
	public void delete(Integer customerId) {
		customerRepository.deleteById(customerId);
	}
	

	
}
