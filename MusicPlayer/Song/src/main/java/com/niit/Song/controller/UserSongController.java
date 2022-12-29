package com.niit.Song.controller;

import com.niit.Song.domain.User;
import com.niit.Song.exception.UserAlreadyExistsException;
import com.niit.Song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class UserSongController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        try{
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        }
        catch(Exception ex){
            throw new UserAlreadyExistsException();
        }
    }
}
