import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { LoanapplicationComponent } from './loanapplication/loanapplication.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoanListWithServerSidePaginationComponent } from './loan-list-with-server-side-pagination/loan-list-with-server-side-pagination.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'welcome/:id', component: WelcomeComponent},
  {path: 'list_loan_with_serverside_pagination', component: LoanListWithServerSidePaginationComponent},
  {path: 'loanapplication/:id', component: LoanapplicationComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
