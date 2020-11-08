import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from './../service/data/loan.service';
import { Loan } from '../welcome/welcome.component';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-loanapplication',
  templateUrl: './loanapplication.component.html',
  styleUrls: ['./loanapplication.component.css'],
  providers: [DatePipe]
})

export class LoanapplicationComponent implements OnInit {

  id: 0;
  loan: Loan;
  even: number;
  currentDate = new Date();

  constructor(
    private loanService: LoanService,
    private route: ActivatedRoute,
    private router: Router,
    public datePipe: DatePipe
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.loan = new Loan(0, 0, 0, new Date(), new Date(), new Date(), 0, 0, 0, '');
  }

  saveLoan(){
    // this.loan.customerId = this.id;
    console.log(this.loan);
    this.loanService.createLoan(this.id, this.loan)
          .subscribe (
            data => {
              console.log(data);
              this.router.navigate(['welcome', this.id]);

            }
          );
  }

}