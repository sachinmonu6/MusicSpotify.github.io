import { Injectable } from '@angular/core';
import { AuthenticationComponent } from './authentication/authentication.component';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() { }



  isLoggedIn: boolean = false;

  
  login() {
    console.log("hello")
    this.isLoggedIn = true;
  }
}
