package com.finzly.loan;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finzly.loan.model.Loan;
import com.finzly.loan.rest.LoanController;
import com.finzly.loan.service.LoanService;

@WebMvcTest(LoanController.class)
public class LoanControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanService loanService;
	
	@Autowired private ObjectMapper mapper;

	@Test
	public void testLoanController() throws Exception {
		
		List<Loan>Listlist=new ArrayList<>();

		Loan loan = new Loan(0,10000,LocalDate.of(2021,5,12),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		loan.setLoanId(0);
		
		Listlist.add(loan);
		
		when(loanService.listAll()).thenReturn(Listlist);
		this.mockMvc.perform(get("/loans")).andDo(print()).andExpect(status().isOk());
//		.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//        .andExpect(jsonPath("$", hasSize(2)))
//        .andExpect(jsonPath("$[0].id", is(1)))
//        .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
//        .andExpect(jsonPath("$[0].title", is("Foo")))
//        .andExpect(jsonPath("$[1].id", is(2)))
//        .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
//        .andExpect(jsonPath("$[1].title", is("Bar")));
	}
	
	@Test
	public void testLoanController_post_mapping() throws Exception {
		Loan loan = new Loan(0,10000,LocalDate.of(2021,5,12),LocalDate.of(2021,5,12),LocalDate.of(2022,5,12),1,12,1,"even");
		loan.setLoanId(0);
				
		when(loanService.save(loan)).thenReturn(loan);
		 String jsonLoan = mapper.writeValueAsString(loan);
		this.mockMvc.perform(  post("/loans")
				.accept(MediaType.APPLICATION_JSON).content(jsonLoan)
				.contentType(MediaType.APPLICATION_JSON)
			    ).andExpect(status().isOk());
		
//		this.mockMvc.perform(post("/loans"))
//		.content(asJsonString(loan))
//        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//		.andDo(print()).andExpect(status().isOk());
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
//@PostMapping("/loans")
//public void add(@RequestBody Loan  loan) {	
//	loanService.save(loan);
//}				.content(objectMapper.writeValueAsString(loan))

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