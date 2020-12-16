package com.finzly.loan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Loan> findPaginatedLoans(int pageNumber, int pageSize){
		Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
		return this.loanRepository.findAll(pageable);
	}
}
