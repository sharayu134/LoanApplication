import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoanService } from '../service/data/loan.service';
import { PaymentScheduleService } from '../service/shedule/payment-schedule.service';
import { Loan }  from '../welcome/welcome.component';
import { PaymentShedule }  from '../welcome/welcome.component';

@Component({
  selector: 'app-loan-list-with-server-side-pagination',
  templateUrl: './loan-list-with-server-side-pagination.component.html',
  styleUrls: ['./loan-list-with-server-side-pagination.component.css']
})

export class LoanListWithServerSidePaginationComponent implements OnInit {

  loans: Loan[];
  paymentShedules: PaymentShedule[];
  p: number = 1;

  isShow = false;
  id = 0;
  loanIdCurrentSchedule = 0;

  //pagination properties
   page:number=1;
   pages:Array<number>;

  constructor(
    private route: ActivatedRoute,
    // tslint:disable-next-line:align
    private router: Router,
    // tslint:disable-next-line:align
    private loanService: LoanService,
    private paymentScheduleService: PaymentScheduleService 
  ) {}
  setPage(i,event:any){
    event.preventDefault();
     this.page=i;
     this.refreshLoans(i);
  }

  ngOnInit(): void {
    // this.route.queryParams.subscribe(x => this.loadPage(x.page || 1));
    this.refreshLoans(1);
    this.refreshPaymentSchedules();
  }
 
  refreshLoans(page) {
    this.loanService.getPaginatedLoanList(page).subscribe(
      data=>{
        console.log(data);
        this.loans=data['content'];
        this.pages= new Array(data['totalPages']);
      },
      (error)=>{
        console.log(error.error.message);
  
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


  viewPaymentSchedule(loanIdCurrentSchedule){
   
    this.router.navigate(['list_payment_schedules', loanIdCurrentSchedule]);
  }
}
