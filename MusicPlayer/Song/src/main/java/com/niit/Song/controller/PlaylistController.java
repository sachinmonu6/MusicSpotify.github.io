package com.niit.Song.controller;

import com.niit.Song.domain.Playlist;
import com.niit.Song.domain.Song;
import com.niit.Song.exception.PlaylistNotFoundException;
import com.niit.Song.exception.UserAlreadyExistsException;
import com.niit.Song.exception.UserNotFoundException;
import com.niit.Song.service.PlaylistService;
import com.niit.Song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/music")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;
    @CrossOrigin(origins="*")
    @GetMapping("/getallplaylists/{emailid}")
    public ResponseEntity<?> getAllplaylists(@PathVariable String emailid) throws PlaylistNotFoundException {
        return new ResponseEntity<>(playlistService.getAllPlaylists(emailid), HttpStatus.OK);
    }


    @CrossOrigin(origins="*")
    @PutMapping("/addsong/{emailid}/{pname}/{songid}")
    public ResponseEntity<?> addSongForPlaylist(@PathVariable String emailid, @PathVariable String pname, @PathVariable Integer songid, @RequestBody Song song) throws UserNotFoundException {
        try{
            return new ResponseEntity<>(playlistService.addSongForPlaylist(songid,song,emailid,pname), HttpStatus.OK);
        }
        catch(Exception ex){
            throw new UserNotFoundException();
        }
    }

    @CrossOrigin(origins="*")
    @PostMapping("/add/list/{pname}/{emailid}")
    public ResponseEntity<?> addSong(@PathVariable String pname,@PathVariable String emailid,@RequestBody Playlist playlist) throws UserAlreadyExistsException {
        playlist.setSonglist(new ArrayList<>());
        System.out.println(pname);
        System.out.println(emailid);
        return new ResponseEntity<>(playlistService.addList(playlist,emailid,pname),HttpStatus.CREATED);
    }
    @CrossOrigin(origins="*")
    @DeleteMapping("/delete/playlist/{pname}/{emailid}")
    public  ResponseEntity<?> deleteProduct(@PathVariable String pname) throws  PlaylistNotFoundException {
        try{
            return new ResponseEntity<>(playlistService.deletePlaylist(pname),HttpStatus.CREATED);
        }
        catch (PlaylistNotFoundException ex){
            throw new PlaylistNotFoundException();
        }
    }
}
