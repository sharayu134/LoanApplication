package com.finzly.loan.model;



import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author USER
 *Loan entity
 */

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id") 
	private int loanId;
	
	@Column(name = "customer_id") 
	private int customerId;
	
	@Column(name = "loan_amount") 
	private double loanAmount;
	
	@Column(name = "trade_date") 
	private LocalDate tradeDate;
	
	@Column(name = "loan_start_date") 
	private LocalDate loanStartDate;
	
	@Column(name = "maturity_date") 
	private LocalDate maturityDate;
	
	@Column(name = "payment_frequency") 
	private int paymentFrequency;
	
	@Column(name = "interestrate") 
	private double interestRate;
	
	@Column(name = "tenure")
	private int tenure;

	@Column(name = "principle")
	private String principle;
	
	
	public Loan(int customerId, double loanAmount, LocalDate tradeDate, LocalDate loanStartDate, LocalDate maturityDate,
			int paymentFrequency, double interestRate, int tenure, String principle) {
		super();
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.tradeDate = tradeDate;
		this.loanStartDate = loanStartDate;
		this.maturityDate = maturityDate;
		this.paymentFrequency = paymentFrequency;
		this.interestRate = interestRate;
		this.tenure = tenure;
		this.principle = principle;
	}


	public Loan() {
	}
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public LocalDate getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}
	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public int getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public int getTenure() {
		return tenure;
	}


	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getPrinciple() {
		return principle;
	}


	public void setPrinciple(String principle) {
		this.principle = principle;
	}


	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", customerId=" + customerId + ", loanAmount=" + loanAmount + ", tradeDate="
				+ tradeDate + ", loanStartDate=" + loanStartDate + ", maturityDate=" + maturityDate
				+ ", paymentFrequency=" + paymentFrequency + ", interestRate=" + interestRate + ", tenure=" + tenure
				+ ", principle=" + principle + "]";
	}

	@Override
	public boolean equals(Object obj) {
//	    if(this == obj)return true;
//	    if(obj == null || obj.getClass()!= this.getClass())return false;

	    Loan loan = (Loan) obj;
	    if(
	    		loan.getCustomerId()==this.customerId&&
	    		loan.getInterestRate()==this.interestRate&&
	    		loan.getLoanAmount()==this.loanAmount&&
	    		loan.getLoanId()==this.loanId&&
	    		(loan.getLoanStartDate().compareTo(this.loanStartDate) ==0 ) &&
	    		(loan.getMaturityDate().compareTo(this.maturityDate) ==0 ) &&
	    		(loan.getTradeDate().compareTo(this.tradeDate) ==0 ) &&
	    		loan.getPaymentFrequency()==this.paymentFrequency&&
	    		loan.getPrinciple()==this.principle&&
	    		loan.getTenure()==this.tenure
  ){return true;}

	    return false;
	}
	
}
