import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentShedule } from 'src/app/welcome/welcome.component';

@Injectable({
  providedIn: 'root'
})
export class PaymentScheduleService {

  constructor(
    private http: HttpClient
  ) { }
  retrieveAllPaymentSchedules() {
    return this.http.get<PaymentShedule[]>(`http://localhost:8080/paymentschedules`);
  }
}
