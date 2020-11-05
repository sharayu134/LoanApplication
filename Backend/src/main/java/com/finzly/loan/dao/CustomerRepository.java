package com.finzly.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.loan.model.Customer;

/**
 * @author USER
 *
 *This is dao for customer entity
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
