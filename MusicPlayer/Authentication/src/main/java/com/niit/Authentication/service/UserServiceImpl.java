package com.niit.Authentication.service;

import com.niit.Authentication.domain.User;
import com.niit.Authentication.exception.UserNotFoundException;
import com.niit.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String em, String pwd) throws UserNotFoundException {
        User user = userRepository.findByEmailidAndPassword(em,pwd);
        if(user!=null){
            return user;
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmailid(String emailid) {
        return userRepository.findByEmailid(emailid);
    }
}
