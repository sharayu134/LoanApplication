import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Loan } from 'src/app/welcome/welcome.component';

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  constructor(
    private http: HttpClient
  ) { }
  retrieveAllLoans() {
    return this.http.get<Loan[]>(`http://localhost:8080/loans`);
  }

  createLoan(id, loan){
    return this.http.post(
      `http://localhost:8080/loans`
        , loan);
  }
 
  getPaginatedLoanList(page:number){
    return this.http.get('http://localhost:8080/loans/list?page='+page);
  }
}
