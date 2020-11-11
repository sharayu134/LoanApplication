package com.finzly.loan.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.model.Loan;
import com.finzly.loan.model.PaymentSchedule;
import com.finzly.loan.service.LoanService;
import com.finzly.loan.service.PaymentScheduleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author USER
 *
 *This is rest controller for getting Loan list, creating new loan and payment schedules.
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoanController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private PaymentScheduleService PaymentScheduleService;
	
	@GetMapping("/loans")
	public List<Loan>list(){
		return loanService.listAll(); 
	}
	
	@PostMapping("/loans")
	public void add(@RequestBody Loan  loan) {	
		loanService.save(loan);
	}
		
	@GetMapping("/loans/{loanId}")
	public  ResponseEntity<Loan> get(@PathVariable Integer loanId) {
		try {
			Loan loan =loanService.get(loanId);
			return new ResponseEntity<Loan>(loan,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
 
		}
	}

}
