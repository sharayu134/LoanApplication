package com.finzly.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author USER
 * Customer entity
 */
@Entity

public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "customerid") 
	private int customerId;
	
	private String password;
	
	public Customer() {
	}
	public Customer(int customerId, String password) {
		this.customerId = customerId;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", password=" + password + "]";
	}

}
