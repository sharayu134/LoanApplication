package com.finzly.loan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.model.Customer;
import com.finzly.loan.service.CustomerService;

/**
 * @author USER
 *
 *This is rest controller for getting customer id and password
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer>  get(@PathVariable Integer customerId) {
		 
			Customer customer =customerService.get(customerId);
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
}
