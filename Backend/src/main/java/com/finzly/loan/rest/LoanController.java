package com.finzly.loan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/loans/page/{pageNumber}/page_size/{pageSize}")
	public String findPaginatedList(@PathVariable (value="pageNumber") int pageNumber,@PathVariable (value="pageSize") int pageSize, Model model){
		
		Page<Loan> page=loanService.findPaginatedLoans(pageNumber, pageSize); 
		List<Loan> loanList=page.getContent();

		model.addAttribute("currentPage",pageNumber);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("titalItems", page.getTotalElements());
		model.addAttribute("loanList",loanList);
		
		return "index"; 
	}
	
	@GetMapping("/loans/page/{pageNumber}/records_per_page/{pageSize}")
	public List<Loan> findPaginatedLoanList(@PathVariable (value="pageNumber") int pageNumber,@PathVariable (value="pageSize") int pageSize, Model model){
		
		Page<Loan> page=loanService.findPaginatedLoans(pageNumber, pageSize); 
		List<Loan> loanList=page.getContent();

		model.addAttribute("currentPage",pageNumber);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("titalItems", page.getTotalElements());
		model.addAttribute("loanList",loanList);
		
		return loanList; 
	}
	
}
