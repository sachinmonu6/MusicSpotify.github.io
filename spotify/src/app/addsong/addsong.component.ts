import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { PlistService } from '../plist.service';

@Component({
  selector: 'app-addsong',
  templateUrl: './addsong.component.html',
  styleUrls: ['./addsong.component.css']
})
export class AddsongComponent implements OnInit {
  
//   plname:any
// sid:any
//   addSongFormGroup= new FormGroup({
//     pname:new FormControl('',[Validators.required]),
//     songid: new FormControl('',[Validators.required]),
//   })
pname:any;
songid:any;
listname:any;

  constructor(private plistservice:PlistService) { }

  ngOnInit(): void {
  }


  addSong(){
    this.plistservice.addSong(this.pname,this.songid).subscribe(
      success =>{
        console.log(success)
      }
      
    )

  }
  
  allsongsdata:any
  getAllPSongs(){
    this.plistservice.getAllPsongs(this.listname).subscribe(
      result => {
        this.allsongsdata = result;
      }
    );
  }

  playSongs(){
    alert("your songlist is being played");
  }

  // get pname(){
  //   return this.addSongFormGroup.get('pname')
  // }
  // get songid(){
  //   return this.addSongFormGroup.get('songid')
  // }
  Play(data :any){
    alert(data)
      }

}
