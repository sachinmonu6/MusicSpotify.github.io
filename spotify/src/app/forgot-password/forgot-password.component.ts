import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private userservice:UserService) { 
      // this.emailid=new User;
  }

  ngOnInit(): void {
  }
  user:User;
  emailid: any;
  userdata!:User[];

  onSubmit() {
    this.userservice.checkAllUser(this.emailid).subscribe(
     result =>{
      this.userdata =  result;
     },
     (err:HttpErrorResponse)=>{
      console.log(err.message);}
     );
  }

}
