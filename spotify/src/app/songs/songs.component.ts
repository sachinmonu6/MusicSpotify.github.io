import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { SongService } from '../song.service';

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.css']
})
export class SongsComponent implements OnInit {

  constructor(private songservice:SongService) { }

  ngOnInit(): void {
  }

  allsongsdata: any;
  getAllSongs(){
    this.songservice.getAllSongs().subscribe(
      result => {
        this.allsongsdata = result;
      }
    );
  }

  Play(data :any){
    alert(data)
      }
}
