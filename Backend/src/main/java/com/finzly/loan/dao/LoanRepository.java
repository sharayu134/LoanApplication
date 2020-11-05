package com.finzly.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.loan.model.Loan;


/**
 * @author USER
 *This is dao for Loan entity
 */
public interface LoanRepository extends JpaRepository<Loan,Integer>{

}