package com.niit.Song.controller;

import com.niit.Song.domain.Song;
import com.niit.Song.exception.UserAlreadyExistsException;
import com.niit.Song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class SongController {
    @Autowired
    private SongService songService;


    @PostMapping("/add/song")
    public ResponseEntity<?> addSong(@RequestBody Song song) throws UserAlreadyExistsException {
        return new ResponseEntity<>(songService.addSong(song),HttpStatus.CREATED);
    }
    @CrossOrigin(origins="*")
    @GetMapping("/getallsongs")
    public ResponseEntity<?> getAllSongs(){
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }
    @CrossOrigin(origins="*")
    @GetMapping("/getallpsongs/{pname}")
    public ResponseEntity<?> getAllPSongs(@PathVariable String pname) {
        return new ResponseEntity<>(songService.getAllPSongs(pname), HttpStatus.OK);
    }

    @GetMapping("Search/{songName}")
    public ResponseEntity<?> getSongByName(@PathVariable String songName){
        return new ResponseEntity<>(songService.getSongByName(songName), HttpStatus.FOUND);
    }
}
