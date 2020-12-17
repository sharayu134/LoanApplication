import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {PaymentScheduleService} from '../service/shedule/payment-schedule.service';
import {PaymentShedule} from '../welcome/welcome.component';


@Component({
  selector: 'app-listpaymentschedules',
  templateUrl: './listpaymentschedules.component.html',
  styleUrls: ['./listpaymentschedules.component.css']
})


export class ListpaymentschedulesComponent implements OnInit {
  loanIdCurrentSchedule:number;
  constructor( private paymentScheduleService: PaymentScheduleService,   private route: ActivatedRoute,
    // tslint:disable-next-line:align
    private router: Router,) { }

  ngOnInit(): void {
    this. loanIdCurrentSchedule= this.route.snapshot.params.id;
    this.refreshPaymentSchedules();
  }


  paymentShedules : PaymentShedule[];
  refreshPaymentSchedules() {
    this.paymentScheduleService.retrieveAllPaymentSchedules().subscribe(
      response => {
        console.log(response);
        this.paymentShedules = response;
      }
    );
  }
  back(){
    this.router.navigate(['welcome', 10001]);
  }

}
