import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Signupdata } from './signupdata';
import { Logindata } from './logindata';
import { User } from './User';
import { Observable, observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpclient:HttpClient) { }

  productuserbaseurl:string="http://localhost:8089/userservice";
  registerUser(data:Signupdata){
    return this.httpclient.post<any>(this.productuserbaseurl+"/register",data);
  }

  
  userauthenticationbaseurl = "http://localhost:8089/userservice";
  logincheck(data: Logindata):Observable<any> {
    return this.httpclient.post<any>(this.userauthenticationbaseurl + "/login", data);
  }

userfindurl="http://localhost:8089/userservice/getBy/";
  checkAllUser(data:any):Observable<any> {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.httpclient.get<any>(this.userfindurl+data);
  }
}


