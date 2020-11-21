package com.finzly.loan.service;

import java.time.LocalDate;
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
	
	LoanService(){}

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private PaymentScheduleService PaymentScheduleService;
	
	public LoanService(LoanRepository loanRepository2, com.finzly.loan.service.PaymentScheduleService paymentScheduleService2) {
		this.loanRepository=loanRepository2;
		this.PaymentScheduleService=paymentScheduleService2;
	}

	public LoanService(LoanRepository loanRepository2) {
		this.loanRepository=loanRepository2;
	}

	public List<Loan> listAll(){
		return loanRepository.findAll();
	}
	
	public Loan save(Loan loan) {
		loan.setTradeDate( LocalDate.now() );
		loan.setMaturityDate(loan.getLoanStartDate().plusYears(loan.getTenure()));
		loanRepository.save(loan);
		PaymentScheduleService.save(loan);	
		return loan;
	}
}
