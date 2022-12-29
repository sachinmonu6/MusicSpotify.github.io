package com.niit.Song.service;
import com.niit.Song.domain.User;
import com.niit.Song.exception.UserAlreadyExistsException;
import com.niit.Song.repository.PlaylistRepository;
import com.niit.Song.repository.SongRepository;
import com.niit.Song.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;
    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmailid()).isEmpty()){
            return userRepository.insert(user);
        }
        else{
            throw new UserAlreadyExistsException();
        }
    }

}

