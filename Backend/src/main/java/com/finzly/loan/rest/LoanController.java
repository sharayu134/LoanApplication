package com.finzly.loan.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.dao.LoanRepository;
import com.finzly.loan.model.Loan;
import com.finzly.loan.service.LoanService;

/**
 * @author USER
 *
 *This is rest controller for getting Loan list, creating new loan and payment schedules.
 */

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
public class LoanController {
			
	
	@Autowired
	private LoanService loanService;
	@GetMapping("/loans")
	public List<Loan>list(){
		return loanService.listAll(); 
	}
	
//	@PostMapping("/loans")
//	public void add(@RequestBody Loan  loan) {	
//		loanService.save(loan);
//}
	
	@PostMapping("/loans")
	public ResponseEntity<Loan> add(@RequestBody Loan  loan) {	
		Loan newLoan=loanService.save(loan);
		return new ResponseEntity<Loan>(newLoan, HttpStatus.CREATED);
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
	
	@Autowired
	private LoanRepository loanRepository;
	
	Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	  @GetMapping("/loans/list")
	  public Page<Loan> listPaginated(@RequestParam int page) {
//		  PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
//		  Page<Loan> page=loanService.findPaginatedLoans(pageNumber, pageSize); 
//		  List<Loan> loanList=page.getContent();
//
//	 
////	    return new PageImpl<>(loanList, pageRequest, page.getTotalElements());
//		  return page;
		  
//		  return loanService.findPaginatedLoans(pageNumber, 5);
	
		  logger.info(""+page);
		  PageRequest pageRequest= PageRequest.of(page, 5);
		  return  loanRepository.findAll(pageRequest);

	  }
	
}
