import { Component, OnInit,Input } from '@angular/core';
import { UserService } from '../user.service';
import { FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Logindata } from '../logindata';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  logindata: Logindata;

  @Input()
  display:boolean

  constructor(private userservice: UserService, private authService:AuthService,private router:Router) {
   // window.localStorage.clear();
  }

  ngOnInit(): void {
  }

loginFormGroup=new FormGroup({
  emailid:new FormControl(''),
  password: new FormControl("")
});

loginCheck(){
  this.authService.login();
  
  window.localStorage.clear();
    this.logindata = this.loginFormGroup.value;
    this.userservice.logincheck(this.logindata).subscribe(
      success => {
        console.log(success);
        window.localStorage.setItem('tgt', success.token);
        window.localStorage.setItem('currentemailid',success.currentemailid);
        this.router.navigateByUrl("/playlist");
      },
      error => {
        console.log(error);
        alert("Wrong User");
      });
      
}

login(){
  this.display=!this.display;
}
get emailid(){
  return this.loginFormGroup.get('emailid')
}

get password(){
  return this.loginFormGroup.get('password')
}

}
