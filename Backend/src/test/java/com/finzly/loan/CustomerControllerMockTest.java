package com.finzly.loan;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.finzly.loan.model.Customer;
import com.finzly.loan.model.Loan;
import com.finzly.loan.rest.CustomerController;
import com.finzly.loan.rest.LoanController;
import com.finzly.loan.service.CustomerService;
import com.finzly.loan.service.LoanService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void testCustomerController() throws Exception {
		
		Customer customer=new Customer(10001,"passsword");

		when(customerService.get(10001)).thenReturn(customer);
		this.mockMvc.perform(get("/customers/10001")).andDo(print()).andExpect(status().isOk());
//		.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//        .andExpect(jsonPath("$", hasSize(2)))
//        .andExpect(jsonPath("$[0].id", is(1)))
//        .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
//        .andExpect(jsonPath("$[0].title", is("Foo")))
//        .andExpect(jsonPath("$[1].id", is(2)))
//        .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
//        .andExpect(jsonPath("$[1].title", is("Bar")));
	}
}

//class LoanControllerMockTest {
//
//	@Test
//	void testList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAdd() {
//		fail("Not yet implemented");
//	}
//
//}