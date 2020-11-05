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
		loan.setTradeDate( LocalDate.now() );
		int n=loan.getPaymentFrequency();
		loan.setMaturityDate(loan.getLoanStartDate().plusYears(loan.getTenure()));
		loan.setPaymentFrequency(n);//is this statement useless?	
		LocalDate localpaymentDate=(loan.getLoanStartDate());		
		loanService.save(loan);
		int loanId=loan.getLoanId();
		double amount=loan.getLoanAmount();
		int numberOfPAymentSchedules=(loan.getTenure()*loan.getPaymentFrequency());
		double principle=(amount)/numberOfPAymentSchedules;
		double interest;
		logger.debug(loan.getPrinciple());
		String even="even";
		boolean a = even.equals(loan.getPrinciple());
		logger.debug(" "+a);
		if(a) {
			for (int i=0;i<numberOfPAymentSchedules;i++)
			{
				interest=((amount-(principle*(i)))*loan.getInterestRate())/(100*loan.getPaymentFrequency());
				localpaymentDate=localpaymentDate.plusMonths( 12/n );
				PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,principle,interest,"projected",(principle+interest));
				PaymentScheduleService.save(paymentSchedule);
			}
		}
		else {
			interest=(amount*loan.getInterestRate()*loan.getTenure())/(100*numberOfPAymentSchedules);
			for (int i=0;i<numberOfPAymentSchedules;i++)
			{
				localpaymentDate=localpaymentDate.plusMonths( 12/n );
				if(i==numberOfPAymentSchedules-1) {
					PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,amount,interest,"projected",interest+amount);
					PaymentScheduleService.save(paymentSchedule);
				}
				else {
					PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,0,interest,"projected",interest);
					PaymentScheduleService.save(paymentSchedule);
				}				
			}
		}
	}
		
	@GetMapping("/loans/{id}")
	public  ResponseEntity<Loan> get(@PathVariable Integer id) {
		//return loanService.get(id);
		try {
			Loan loan =loanService.get(id);
			return new ResponseEntity<Loan>(loan,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
 
		}
	}

}
