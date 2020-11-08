package com.finzly.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.loan.dao.PaymentScheduleRepository;
import com.finzly.loan.model.PaymentSchedule;


/**
 * @author USER
 * This is Payment Schedule service class
 */

@Service
public class PaymentScheduleService {
	
	@Autowired
	private PaymentScheduleRepository paymentScheduleRepository;
	
	public List<PaymentSchedule> listAll(){
		return paymentScheduleRepository.findAll();
	}
	
	public void save(PaymentSchedule paymentSchedule) {
		paymentScheduleRepository.save(paymentSchedule);
	}
	
	public PaymentSchedule get(Integer id) {
		return paymentScheduleRepository.findById(id).get();
	}
	
	
	public void delete(Integer id) {
		paymentScheduleRepository.deleteById(id);
	}

}
