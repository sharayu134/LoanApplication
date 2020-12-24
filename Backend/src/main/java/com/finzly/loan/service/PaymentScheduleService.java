package com.finzly.loan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.loan.dao.PaymentScheduleRepository;
import com.finzly.loan.model.Loan;
import com.finzly.loan.model.PaymentSchedule;


/**
 * @author USER
 * This is Payment Schedule service class
 */

@Service
public class PaymentScheduleService {
	PaymentScheduleService(){}

	@Autowired
	private PaymentScheduleRepository paymentScheduleRepository;
	
	public PaymentScheduleService(PaymentScheduleRepository paymentScheduleRepository2) {
		this.paymentScheduleRepository=paymentScheduleRepository2;
	}

	public List<PaymentSchedule> listAll(){
		return paymentScheduleRepository.findAll();
	}
	
	public List<PaymentSchedule> savePaymentSchedule(Loan loan) {
		
		List<PaymentSchedule>paymentScheduleList = new ArrayList<PaymentSchedule>(); 
		String even="EVEN";
		if(even.equals(loan.getPrinciple())) {
			paymentScheduleList=processEvenPrinciple(loan);
		}
		else {
			paymentScheduleList=processInterestOnlyPrinciple(loan);
		}
		
		return paymentScheduleList;
	}
	
	
public List<PaymentSchedule> processEvenPrinciple(Loan loan) {
				
		List<PaymentSchedule>paymentScheduleList = new ArrayList<PaymentSchedule>(); 
		int paymentFrequencyYearly=loan.getPaymentFrequency();
		LocalDate localpaymentDate=(loan.getLoanStartDate());	
		double amount=loan.getLoanAmount();
		int numberOfPAymentSchedules=(loan.getTenure()*loan.getPaymentFrequency());
		double principle=(amount)/numberOfPAymentSchedules;
		double interest;
			for (int i=0;i<numberOfPAymentSchedules;i++)
			{
				interest=((amount-(principle*(i)))*loan.getInterestRate()*loan.getTenure())/(100*loan.getPaymentFrequency());
				localpaymentDate=localpaymentDate.plusMonths( 12/paymentFrequencyYearly );
				PaymentSchedule paymentSchedule =new PaymentSchedule(loan.getLoanId(),localpaymentDate,principle,interest,"PROJECTED",(principle+interest));
				paymentScheduleRepository.save(paymentSchedule);
				paymentScheduleList.add(paymentSchedule);
			
			}
	
		return paymentScheduleList;
	}

public List<PaymentSchedule> processInterestOnlyPrinciple(Loan loan) {	
	
	List<PaymentSchedule>paymentScheduleList = new ArrayList<PaymentSchedule>(); 
	int paymentFrequencyYearly=loan.getPaymentFrequency();
	LocalDate localpaymentDate=(loan.getLoanStartDate());	
	int loanId=loan.getLoanId();
	double amount=loan.getLoanAmount();
	int numberOfPAymentSchedules=(loan.getTenure()*loan.getPaymentFrequency());
	double interest=(amount*loan.getInterestRate()*loan.getTenure())/(100*numberOfPAymentSchedules);
	
		for (int i=0;i<numberOfPAymentSchedules;i++)
		{
			localpaymentDate=localpaymentDate.plusMonths( 12/paymentFrequencyYearly );
			if(i==numberOfPAymentSchedules-1) {
				PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,amount,interest,"PROJECTED",interest+amount);
				paymentScheduleRepository.save(paymentSchedule);
				paymentScheduleList.add(paymentSchedule);
			}
			else {
				PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,0,interest,"PROJECTED",interest);
				paymentScheduleRepository.save(paymentSchedule);
				paymentScheduleList.add(paymentSchedule);
			}				
		}	
	
	return paymentScheduleList;
}

//public List<PaymentSchedule> listByID(int loanID){
////return paymentScheduleRepository.findById(loanID);
//paymentScheduleRepository.f
//Optional<PaymentSchedule> optinalEntity =  paymentScheduleRepository.findById(loanID);
//PaymentSchedule paymentSchedule = optinalEntity.get();
//return paymentSchedule;
//}

//public List<PaymentSchedule> save(Loan loan) {
//
//// Todo = try to divide function into smaller functions, one function should perform only one task , (5-6 lines)
//
//List<PaymentSchedule>paymentScheduleList = new ArrayList<PaymentSchedule>(); 
//int paymentFrequencyYearly=loan.getPaymentFrequency();
//LocalDate localpaymentDate=(loan.getLoanStartDate());	
//
//int loanId=loan.getLoanId();
//double amount=loan.getLoanAmount();
//int numberOfPAymentSchedules=(loan.getTenure()*loan.getPaymentFrequency());
//double principle=(amount)/numberOfPAymentSchedules;
//double interest;
//String even="EVEN";
//if(even.equals(loan.getPrinciple())) {
//for (int i=0;i<numberOfPAymentSchedules;i++)
//{
//	interest=((amount-(principle*(i)))*loan.getInterestRate()*loan.getTenure())/(100*loan.getPaymentFrequency());
//	localpaymentDate=localpaymentDate.plusMonths( 12/paymentFrequencyYearly );
//	PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,principle,interest,"PROJECTED",(principle+interest));
//	paymentScheduleRepository.save(paymentSchedule);
//	paymentScheduleList.add(paymentSchedule);
//
//}
//}
//else {
//interest=(amount*loan.getInterestRate()*loan.getTenure())/(100*numberOfPAymentSchedules);
//for (int i=0;i<numberOfPAymentSchedules;i++)
//{
//	localpaymentDate=localpaymentDate.plusMonths( 12/paymentFrequencyYearly );
//	if(i==numberOfPAymentSchedules-1) {
//		PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,amount,interest,"PROJECTED",interest+amount);
//		paymentScheduleRepository.save(paymentSchedule);
//		paymentScheduleList.add(paymentSchedule);
//	}
//	else {
//		PaymentSchedule paymentSchedule =new PaymentSchedule(loanId,localpaymentDate,0,interest,"PROJECTED",interest);
//		paymentScheduleRepository.save(paymentSchedule);
//		paymentScheduleList.add(paymentSchedule);
//	}				
//}
//}
//
//return paymentScheduleList;
//}

}
