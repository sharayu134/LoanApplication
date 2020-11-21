package com.finzly.loan.model;


import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author USER
 *Payment Schedule entity
 */
@Entity
@Table(name = "paymentschedule")
public class PaymentSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentscheduleid") 
	private int paymentScheduleId;
	
	@Column(name = "loanid") 
	private int loanId;
	
	@Column(name = "paymentdate") 
	private LocalDate paymentDate;
	
	@Column(name = "principal") 
	private double principal;
	
	@Column(name = "projectedinterest") 
	private double projectedInterest;
	
	@Column(name = "paymentstatus") 
	private String paymentStatus;
	
	@Column(name = "paymentamount") 
	private double paymentAmount;
	
	
	public PaymentSchedule() {
	}
	
	
	public PaymentSchedule(int loanId, LocalDate paymentDate, double principal,
			double projectedInterest, String paymentStatus, double paymentAmount) {
		super();
		this.loanId = loanId;
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectedInterest = projectedInterest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}


	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getProjectedInterest() {
		return projectedInterest;
	}
	public void setProjectedInterest(double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentScheduleId() {
		return paymentScheduleId;
	}
	public void setPaymentScheduleId(int paymentScheduleId) {
		this.paymentScheduleId = paymentScheduleId;
	}
	@Override
	public String toString() {
		return "PaymentSchedule [paymentScheduleId=" + paymentScheduleId + ", loanId=" + loanId + ", paymentDate="
				+ paymentDate + ", principal=" + principal + ", projectedInterest=" + projectedInterest
				+ ", paymentStatus=" + paymentStatus + ", paymentAmount=" + paymentAmount + "]";
	}
	@Override
	public boolean equals(Object obj) {
//	    if(this == obj)return true;

//	  	    if(obj == null || obj.getClass()!= this.getClass())return false;

	    PaymentSchedule paymentSchedule = (PaymentSchedule) obj;
	    if(paymentSchedule.getPaymentStatus().equals(this.paymentStatus) &&
	            (paymentSchedule.getLoanId() == this.loanId) &&
	            (paymentSchedule.getPaymentAmount() == this.paymentAmount) && 
	            (paymentSchedule.getPaymentDate().compareTo(this.paymentDate) ==0 ) &&
	            (paymentSchedule.getPaymentScheduleId() == this.paymentScheduleId) &&
	            (paymentSchedule.getPrincipal() == this.principal) &&
	            (paymentSchedule.getProjectedInterest() == this.projectedInterest) 
  ){return true;}

	    return false;
	}
}
