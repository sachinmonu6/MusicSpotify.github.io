import { Component, OnInit } from '@angular/core';
import { SongService } from '../song.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private songservice:SongService) { }

  ngOnInit(): void {
  }
  listname:any
  allsongsdata: any;
  getAllSongs(){
    this.songservice.getSongByName(this.listname).subscribe(
      result => {
        this.allsongsdata = result;
      }
    );
  }
}
