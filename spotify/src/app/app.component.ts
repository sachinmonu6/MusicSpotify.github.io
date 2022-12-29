import { Component } from '@angular/core';
import { windowWhen } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
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
  
}
