package com.finzly.loan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finzly.loan.dao.LoanRepository;
import com.finzly.loan.model.Loan;
import com.finzly.loan.model.PaymentSchedule;
import com.finzly.loan.service.LoanService;
import com.finzly.loan.service.PaymentScheduleService;

class LoanServiceMockTest {
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@org.junit.jupiter.api.Test
	void testfor_save_loan() {
		PaymentScheduleService paymentScheduleService = mock(PaymentScheduleService.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		List<PaymentSchedule> paymentScheduleList = new ArrayList<PaymentSchedule>();
		paymentScheduleList.add(mockPaymentSchedule);
		when(paymentScheduleService.save(any(Loan.class))).thenReturn(paymentScheduleList);
		LoanRepository loanRepository = mock(LoanRepository.class);
		Loan mockloan =new Loan(0,10000,LocalDate.now(),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		mockloan.setLoanId(0);
		when(loanRepository.save(any(Loan.class))).thenReturn(mockloan);
		
		Loan loan = new Loan(0,10000,LocalDate.of(2021,5,12),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		LoanService loanService=new LoanService(loanRepository,paymentScheduleService);
		Loan actualLoan =loanService.save(loan);
		Loan expectedLoan =new Loan(0,10000,LocalDate.now(),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		expectedLoan.setLoanId(0);
		assertEquals(expectedLoan, actualLoan);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_listAll() {
		
		LoanRepository loanRepository = mock(LoanRepository.class);
		
		List<Loan>mockLoanList = new ArrayList<Loan>(); 
		Loan mockLoan = new Loan();
		mockLoan.setCustomerId(0);
		mockLoan.setInterestRate(12);
		mockLoan.setLoanAmount(10000);
		mockLoan.setLoanId(0);
		mockLoan.setLoanStartDate(LocalDate.of(2021,5,12));
		mockLoan.setMaturityDate(LocalDate.of(2022,5,12));
		mockLoan.setPaymentFrequency(1);
		mockLoan.setPrinciple("even");
		mockLoan.setTradeDate(LocalDate.of(2021,5,12));
		mockLoan.setTenure(1);
		mockLoan.setLoanId(0);
		mockLoanList.add(mockLoan);

		when(loanRepository.findAll()).thenReturn(mockLoanList);
		
		List<Loan>expectedLoanList = new ArrayList<Loan>(); 
		Loan loan = new Loan(0,10000,LocalDate.of(2021,5,12),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		loan.setLoanId(0);
		expectedLoanList.add(loan);
		LoanService loanService=new LoanService(loanRepository);

		List<Loan> actualLoanList=loanService.listAll();
		
		assertIterableEquals(expectedLoanList, actualLoanList);
		Loan actualLoan=actualLoanList.get(0);
		actualLoan.getCustomerId();
		actualLoan.getInterestRate();
		actualLoan.getLoanAmount();
		actualLoan.getLoanId();
		actualLoan.getLoanStartDate();
		actualLoan.getMaturityDate();
		actualLoan.getTradeDate();
		actualLoan.getPaymentFrequency();
		actualLoan.getTenure();
		actualLoan.getPrinciple();
		
		logger.debug(actualLoan.toString());
				
	}
	
}
