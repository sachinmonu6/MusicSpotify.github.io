package com.niit.Authentication.controller;

import com.niit.Authentication.domain.User;
import com.niit.Authentication.exception.UserNotFoundException;
import com.niit.Authentication.service.SecurityTokenGenerator;
import com.niit.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/userservice")
public class UserController {
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user ) throws UserNotFoundException {
        Map<String, String> map=null;
        try{
            User result = userService.authenticateUser(user.getEmailid(),user.getPassword());

            map= securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(map,HttpStatus.OK); // token, message, emailid
        }
        catch(UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>("Other exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getallusers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/getBy/{emailid}")
    public ResponseEntity<?>getByEmail(@PathVariable String emailid){
        return new ResponseEntity<>(userService.findUserByEmailid(emailid), HttpStatus.FOUND);
    }
}
