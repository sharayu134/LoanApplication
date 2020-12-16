import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from '../service/data/loan.service';
import { PaymentScheduleService } from '../service/shedule/payment-schedule.service';

export class Loan {
  constructor(
    public loanId: number,
    public customerId: number,
    public loanAmount: number,
    public tradeDate: Date,
    public loanStartDate: Date,
    public maturityDate: Date,
    public paymentFrequency: number,
    public interestRate: number,
    public tenure: number,
    public principle: string
  ) {

  }
}

export class PaymentShedule {
  constructor(
    public loanId: number,
    public paymentScheduleId: number,
    public paymentDate: Date,
    public principal: number,
    public projectedInterest: number,
    public paymentStatus: string,
    public paymentAmount: number,
  ) {

  }
}
@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  loans: Loan[];
  paymentShedules: PaymentShedule[];
  p: number = 1;
  // loantodo = [
  //   {id: 2, des: 'o'},
  //   {
  //   id: 1,
  //   des: 'sd'
  // }];
  isShow = false;
  id = 0;
  loanIdCurrentSchedule = 0;
   constructor(
    private route: ActivatedRoute,
    // tslint:disable-next-line:align
    private router: Router,
    // tslint:disable-next-line:align
    private loanService: LoanService,
    private paymentScheduleService: PaymentScheduleService ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.refreshLoans();
    this.refreshPaymentSchedules();
    console.log(this.id);
  }
 // retrieveAllPaymentSchedules
  refreshLoans() {
    this.loanService.retrieveAllLoans().subscribe(
      response => {
        console.log(response);
        this.loans = response;
      }
    );
  }

  refreshPaymentSchedules() {
    this.paymentScheduleService.retrieveAllPaymentSchedules().subscribe(
      response => {
        console.log(response);
        this.paymentShedules = response;
      }
    );
  }

  addLoan(id) {
    this.router.navigate(['loanapplication', id]);
  }
  toggleDisplay(loanIdCurrentSchedule) {
    this.isShow = !this.isShow;
    this.loanIdCurrentSchedule = loanIdCurrentSchedule;
  }

}
