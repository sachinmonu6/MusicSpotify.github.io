package com.niit.Song.service;
import com.niit.Song.domain.User;
import com.niit.Song.exception.UserAlreadyExistsException;

public interface UserService {
    public abstract User addUser(User user) throws UserAlreadyExistsException;
}
