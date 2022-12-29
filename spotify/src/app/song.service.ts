import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Delplistdata } from './delplistdata';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private httpClient:HttpClient) { 
    window.localStorage.clear();
  }

  songsbaseurl:string="http://localhost:64100/music";

  getAllSongs(){
    // let reqHeader= new HttpHeaders().set('Authorization','No Auth ')
    return this.httpClient.get<any>(this.songsbaseurl +"/getallsongs");
  } 

   
  addNewSong(data:any):Observable<any>{
 return this.httpClient.post(this.songsbaseurl +"/add/song",data);
  }

  deleteurl="http://localhost:64100/music/delete/playlist/";
  deletePlaylist(data:any,abc:any)
  {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.httpClient.delete<any>(this.deleteurl+abc+"/"+window.localStorage.getItem('currentemailid'),data);
  }

  getSongByName(data:any){
    return this.httpClient.get<any>(this.songsbaseurl+"/Search/"+data);
     }
}

