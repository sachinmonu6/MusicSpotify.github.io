package com.niit.Authentication.service;

import com.niit.Authentication.domain.User;
import com.niit.Authentication.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public abstract User saveUser(User user);
    public abstract User authenticateUser(String email,String pwd) throws UserNotFoundException;
    public abstract List<User> getAllUsers();
    public User findUserByEmailid(String emailid);
}
