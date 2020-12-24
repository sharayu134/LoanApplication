import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from './../service/data/loan.service';
import { Loan } from '../welcome/welcome.component';
import { DatePipe } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validators } from '@angular/forms';

enum PaymentStatus {
  even = 'EVEN',
  interestOnly = 'INTEREST_ONLY',
}

@Component({
  selector: 'app-loanapplication',
  templateUrl: './loanapplication.component.html',
  styleUrls: ['./loanapplication.component.css'],
  providers: [DatePipe],
})


export class LoanapplicationComponent implements OnInit {
  
  paymentStatus = PaymentStatus;

  form = new FormGroup({
    customerId: new FormControl('', [Validators.required,Validators.min(10000)]),
    loanAmount: new FormControl('', [Validators.required,Validators.min(1)]),
    interestRate: new FormControl('', [Validators.required,Validators.min(1)]),
    tenure: new FormControl('', [Validators.required,Validators.min(1)]),    
    principle: new FormControl('', Validators.required),
    paymentFrequency: new FormControl('', Validators.required),    
   });

   

  id: 0;
  loan: Loan;
  even: number;
  currentDate = new Date();
  evenString='EVEN';
  interestOnlyString='INTEREST_ONLY';

  constructor(
    private loanService: LoanService,
    private route: ActivatedRoute,
    private router: Router,
    public datePipe: DatePipe,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.loan = new Loan(0, 0, 0, new Date(), new Date(), new Date(), 0, 0, 0, '');
  }
  // '1.0-0'
  saveLoan(){
    console.log(this.loan);
    // this.loan.maturityDate=new Date();
    // this.loan.tradeDate=new Date();
    this.loanService.createLoan(this.id, this.loan)
          .subscribe (
            data => {
              console.log(data);
              this.router.navigate(['welcome', this.id]);
              if(data){this.toastr.info('Loan created successfully', '');}
            }
          );

  }

}