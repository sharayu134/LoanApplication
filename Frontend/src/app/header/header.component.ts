import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../service/authentication/authentication-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(
    public authenticationServiceService: AuthenticationServiceService
  ) { }

  ngOnInit(): void {
  }

}
