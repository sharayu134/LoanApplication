package com.finzly.loan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finzly.loan.rest.CustomerController;
import com.finzly.loan.rest.LoanController;
import com.finzly.loan.rest.PaymentScheduleController;

@SpringBootTest
class LoanApplicationTests {
	
	@Autowired
	private CustomerController customerController;

	@Autowired
	private LoanController loanController;
	
	@Autowired
	private PaymentScheduleController paymentScheduleController;

	@Test
	void contextLoadsCustomerController()throws Exception {
		assertThat(customerController).isNotNull();
	}
	@Test
	void contextLoadsLoanController()throws Exception {
		assertThat(loanController).isNotNull();
	}

	@Test
	void contextLoadsPaymentScheduleController()throws Exception {
		assertThat(paymentScheduleController).isNotNull();
	}

}
