package com.finzly.loan;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.finzly.loan.model.PaymentSchedule;
import com.finzly.loan.rest.PaymentScheduleController;
import com.finzly.loan.service.PaymentScheduleService;

@WebMvcTest(PaymentScheduleController.class)
public class PaymentScheduleControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentScheduleService paymentScheduleService;

	@Test
	public void testPaymentScheduleController() throws Exception {
		 List<PaymentSchedule>list=new ArrayList<>();
				 
				 PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
			mockPaymentSchedule.setPaymentScheduleId(0);
			list.add(mockPaymentSchedule);
			
		when(paymentScheduleService.listAll()).thenReturn(list);
		this.mockMvc.perform(get("/paymentschedules")).andDo(print()).andExpect(status().isOk());
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