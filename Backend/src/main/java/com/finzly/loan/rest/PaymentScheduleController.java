package com.finzly.loan.rest;

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
	
	@PostMapping("/paymentschedules")
	public void add(@RequestBody PaymentSchedule  paymentSchedule) {
		paymentScheduleService.save(paymentSchedule);
	}
	
	
	@GetMapping("/paymentschedules/{id}")
	public ResponseEntity<PaymentSchedule> get(@PathVariable Integer id) {
				try {
					PaymentSchedule paymentSchedule =paymentScheduleService.get(id);
					return new ResponseEntity<PaymentSchedule>(paymentSchedule,HttpStatus.OK);
				}catch(NoSuchElementException e) {
					return new ResponseEntity<PaymentSchedule>(HttpStatus.NOT_FOUND);
		 
				}
	}

}
