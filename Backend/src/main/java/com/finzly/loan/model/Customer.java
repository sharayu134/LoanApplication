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

	@Override
	public boolean equals(Object obj) {
//	if(this == obj)return true;
//	if(obj == null || obj.getClass()!= this.getClass())return false;
	Customer customer = (Customer) obj;
	 if(customer.getCustomerId()==this.customerId&&customer.getPassword()==this.password){return true;}
    return false;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
