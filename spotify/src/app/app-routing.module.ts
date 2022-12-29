import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewSongComponent } from './add-new-song/add-new-song.component';
import { AddsongComponent } from './addsong/addsong.component';
import { AuthGuard } from './auth.guard';
import { AuthenticationComponent } from './authentication/authentication.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { SongsComponent } from './songs/songs.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "playlist",
    canActivate:[AuthGuard],
    component: PlaylistComponent,
    
  },
  {
    path: "addsong",
    component: AddsongComponent,
    
  },
  {
    path: "search",
    component: SearchComponent,
    
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "add-new-song",
    canActivate:[AuthGuard],
    component: AddNewSongComponent
  },
  {
    path: "login",
    component: AuthenticationComponent
  },
  {
    path: "getsong",
    component: SongsComponent
  },
  {
    path: "forgotPassword",
    component: ForgotPasswordComponent
  },
  {
    path:'', redirectTo:'/home', pathMatch:"full"
  
  },
   {
    path: "**", component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
