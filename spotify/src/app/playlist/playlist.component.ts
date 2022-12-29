import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Plistdata } from '../plistdata';
import { PlistService } from '../plist.service';
import { Delplistdata } from '../delplistdata';
import { SongService } from '../song.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  plistdata:Plistdata
  deleteplistdata:Delplistdata
abc:any
// pname:any
  constructor(private plistservice:PlistService, private songservice:SongService,) { }

  ngOnInit(): void {
  }

  addPlaylistFormGroup= new FormGroup({
    pname:new FormControl(''),
    emailid: new FormControl(""),
});


plistdataa:any
getAllPlaylists(){
  this.plistservice.getAllPlaylists().subscribe(
  result => {
    this.plistdataa = result;
  }
);
}

addPlaylist(){
      this.addPlaylistFormGroup.value.emailid=window.localStorage.getItem("currentemailid")
    this.abc=this.addPlaylistFormGroup.value.pname
      console.log(this.addPlaylistFormGroup.value);
  this.plistdata=this.addPlaylistFormGroup.value;
  console.log(this.plistdata);
  this.plistservice.addPlaylist(this.plistdata,this.abc).subscribe(
    success => {
      console.log(success);
      // window.localStorage.setItem('token', success.token);
    },
    response => {
      console.log("playlist adding failed : ");
      console.log(response);
    })
}

deletePlaylistFormGroup= new FormGroup({
  pname:new FormControl(''),
});

deletePlaylist()
{
  this.deletePlaylistFormGroup.value.emailid=window.localStorage.getItem("currentemailid")
  this.abc=this.deletePlaylistFormGroup.value.pname
    console.log(this.deletePlaylistFormGroup.value);
this.deleteplistdata=this.deletePlaylistFormGroup.value;
console.log(this.deleteplistdata);
this.songservice.deletePlaylist(this.deleteplistdata,this.abc).subscribe(
  success => {
    console.log(success);
    // window.localStorage.setItem('token', success.token);
  },
  error => {
    console.log("playlist delete failed : ");
    console.log(error);
  })
}

get pname(){
  return this.addPlaylistFormGroup.get('pname') 
}

get emailid(){
  return this.addPlaylistFormGroup.get('emailid')
}
get delete(){
  return this.addPlaylistFormGroup.get('delete')
}

}
