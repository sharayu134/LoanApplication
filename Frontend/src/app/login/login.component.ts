import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../service/authentication/authentication-service.service';

export class Customer {
  constructor(
    public customerId: number,
    public password: string){}}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer: Customer;
  formCustomerId = 10001;
  formPassword = 'password1';
  errorMessage = 'Invalid Credentials';
  invalidLogin = false;
  constructor(private router: Router,
              private authenticationService: AuthenticationServiceService,
            ) { }

  ngOnInit(): void {
    this.authenticationService.logout();
  }

  handleLogin(){
    this.authenticationService.retrieveAllPaymentSchedules(this.formCustomerId).subscribe(
      response => {
        console.log(response);
        this.customer = response;
      }
    );
    if ( this.customer.password === this.formPassword){
      this.invalidLogin = false;
      console.log(this.formCustomerId);
      this.router.navigate(['welcome', this.formCustomerId]);
    }else{
      this.invalidLogin = true;
      console.log(this.invalidLogin);
    }

  }

}
