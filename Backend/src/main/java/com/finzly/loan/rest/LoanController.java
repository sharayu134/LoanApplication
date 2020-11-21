package com.finzly.loan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.model.Loan;
import com.finzly.loan.service.LoanService;

/**
 * @author USER
 *
 *This is rest controller for getting Loan list, creating new loan and payment schedules.
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoanController {
			
	@Autowired
	private LoanService loanService;
	@GetMapping("/loans")
	public List<Loan>list(){
		return loanService.listAll(); 
	}
	
	@PostMapping("/loans")
	public void add(@RequestBody Loan  loan) {	
		loanService.save(loan);
}
}
