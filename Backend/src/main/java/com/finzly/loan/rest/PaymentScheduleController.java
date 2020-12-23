package com.finzly.loan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.model.PaymentSchedule;
import com.finzly.loan.service.PaymentScheduleService;

/**
 * @author USER
 *This is rest controller for getting list of payment schedule
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PaymentScheduleController {
	
	@Autowired
	private PaymentScheduleService paymentScheduleService;
	
	@GetMapping("/paymentschedules")
	public List<PaymentSchedule>list(){
		return paymentScheduleService.listAll(); 
	}
	
//	@GetMapping("/paymentschedule/{loan_id}")
//	public List<PaymentSchedule>listPerId(@PathVariable Integer loan_id){
//		return paymentScheduleService.listByID(loan_id);
//	}
}
