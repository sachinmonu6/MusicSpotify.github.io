import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Plistdata } from './plistdata';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlistService {

  constructor(private httpclient:HttpClient) { }
  addplisterbaseurl:string="http://localhost:64100/music/add";


  addPlaylist(data:Plistdata,abc:any){
    // console.log(data);
    
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.httpclient.post<any>(this.addplisterbaseurl+"/list/"+abc+"/"+window.localStorage.getItem('currentemailid'),data)
  }

  addSong(pname:any,songid:any){
    console.log(window.localStorage.getItem('currentemailid'));
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.httpclient.put<any>("http://localhost:64100/music/addsong/"+window.localStorage.getItem('currentemailid')+"/"+pname+"/"+songid,{ 'headers': reqHeader });
  }

  getAllPlaylists(){
    // let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token')); 
    return this.httpclient.get<any>("http://localhost:64100/music/getallplaylists/"+window.localStorage.getItem('currentemailid'));
  }
  
  getAllPsongs(data:any){
    return this.httpclient.get<any>("http://localhost:64100/music/getallpsongs/"+data);

  }

}
