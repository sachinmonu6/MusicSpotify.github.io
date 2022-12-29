import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }
  title = 'spotify';

  display=false;
  logout(){
    
  }

loggedin(){
 // return localStorage.getItem("token");
  this.display=!this.display;
}

onlogout()
{
  // localStorage.removeItem("token");
  window.localStorage.clear();
  this.display=!this.display;
}

  ngOnInit(): void {
  }

}
