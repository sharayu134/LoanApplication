package com.finzly.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.loan.dao.LoanRepository;
import com.finzly.loan.model.Loan;

/**
 * @author USER
 * This is Loan Service Class
 */

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	public List<Loan> listAll(){
		return loanRepository.findAll();
	}
	
	public void save(Loan loan) {
		loanRepository.save(loan);
	}
	
	public Loan get(Integer loanId) {
		return loanRepository.findById(loanId).get();
	}
	
	
	public void delete(Integer loanId) {
		loanRepository.deleteById(loanId);
	}
}
