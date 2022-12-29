import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Signupdata } from '../signupdata';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signupdata: Signupdata|undefined;

  constructor(private userservice: UserService) {
 //   window.localStorage.clear();
  }

  ngOnInit(): void{
    // throw new Error('Method not implemented.');
  }


userFormGroup= new FormGroup({
  emailid: new FormControl('',[Validators.required]),
  userid:new FormControl('',[Validators.required]),
  password:new FormControl('',[Validators.required]),
  role:new FormControl('',[Validators.required]),
})

signup(){
  console.log(this.userFormGroup.value);
  this.signupdata=this.userFormGroup.value;
  console.log(this.signupdata);
  this.userservice.registerUser(this.signupdata).subscribe(
    response => {
      console.log("User registration success : ");
      alert("user registered Sucessfully, click on login")
      console.log(response);
    })
}


get emailid(){
  return this.userFormGroup.get('emailid')
}
get userid(){
  return this.userFormGroup.get('userid')
}
get password(){
  return this.userFormGroup.get('password')
}
get role(){
  return this.userFormGroup.get('role')
}

}
