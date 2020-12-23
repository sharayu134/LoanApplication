import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoanapplicationComponent } from './loanapplication/loanapplication.component';

import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import {NgxPaginationModule} from 'ngx-pagination';
import { LoanListWithServerSidePaginationComponent } from './loan-list-with-server-side-pagination/loan-list-with-server-side-pagination.component'; // <-- import the module

import {LoanService} from '../app/service/data/loan.service';
import { ListpaymentschedulesComponent } from './listpaymentschedules/listpaymentschedules.component';

import { ReactiveFormsModule } from '@angular/forms';
import { CurrencyMaskModule } from "ng2-currency-mask";
import { from } from 'rxjs';
// ./number-comma.directive';
@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    HeaderComponent,
    FooterComponent,
    LoanapplicationComponent,
    LoanListWithServerSidePaginationComponent,
    ListpaymentschedulesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    NgxPaginationModule,
    ReactiveFormsModule,CurrencyMaskModule
  ],
  providers: [LoanService],
  bootstrap: [AppComponent]
})
export class AppModule { }
