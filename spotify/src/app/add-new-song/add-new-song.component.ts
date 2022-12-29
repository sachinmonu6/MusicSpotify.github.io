import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { SongService } from '../song.service';

@Component({
  selector: 'app-add-new-song',
  templateUrl: './add-new-song.component.html',
  styleUrls: ['./add-new-song.component.css']
})
export class AddNewSongComponent implements OnInit {

  constructor(private songservice:SongService, private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  songDetails=this.fb.group({
    songId:['',Validators.required],
    songName:['',Validators.required],
    artist:['',Validators.required],
    releaseYear:['',Validators.required],
    pname:['',Validators.required]
  })
  addNewSong( ){
    this.songservice.addNewSong(this.songDetails.value).subscribe(()=>alert("Song Added Successfully!"))  
  }
  
  get songId(){
    return this.songDetails.get('songId') 
  } 

  get songName(){
    return this.songDetails.get('songName') 
  }

  get artist(){
    return this.songDetails.get('artist') 
  }
  
  get releaseYear(){
    return this.songDetails.get('releaseYear') 
  }
  get pname(){
    return this.songDetails.get('pname') 
  }
}
