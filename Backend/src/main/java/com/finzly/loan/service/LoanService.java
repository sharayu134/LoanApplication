package com.finzly.loan.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.loan.dao.LoanRepository;
import com.finzly.loan.model.Loan;
import com.finzly.loan.model.PaymentSchedule;

/**
 * @author USER
 * This is Loan Service Class
 */

@Service
public class LoanService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private PaymentScheduleService PaymentScheduleService;
	
	public List<Loan> listAll(){
		return loanRepository.findAll();
	}
	
	public void save(Loan loan) {
		loan.setTradeDate( LocalDate.now() );
		int n=loan.getPaymentFrequency();
		loan.setMaturityDate(loan.getLoanStartDate().plusYears(loan.getTenure()));
		loan.setPaymentFrequency(n);//is this statement useless?	
		LocalDate localpaymentDate=(loan.getLoanStartDate());	
		loanRepository.save(loan);
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
	
	public Loan get(Integer loanId) {
		return loanRepository.findById(loanId).get();
	}
	
	
	public void delete(Integer loanId) {
		loanRepository.deleteById(loanId);
	}
}
