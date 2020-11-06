import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from 'src/app/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  isloggedIn = false;

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllPaymentSchedules(id) {
    this.isloggedIn = true;
    return this.http.get<Customer>(`http://localhost:8080/customers/${id}`);
  }
  isUserLoggedIn(){
    if (this.isloggedIn){
      return true;
    }
    else
    { return false;
  }
}
logout(){
  this.isloggedIn = false;
}
}
