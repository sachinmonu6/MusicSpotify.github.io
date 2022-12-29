package com.niit.Song.service;

import com.niit.Song.domain.Playlist;
import com.niit.Song.domain.Song;
import com.niit.Song.exception.PlaylistNotFoundException;
import com.niit.Song.exception.UserNotFoundException;
import com.niit.Song.repository.PlaylistRepository;
import com.niit.Song.repository.SongRepository;
import com.niit.Song.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaylistRepository playlistRepository;
    @Override
    public List<Playlist> getAllPlaylists(String emailid) throws PlaylistNotFoundException {
        return playlistRepository.findByEmailid(emailid);
    }

    @Override
    public Playlist addList(Playlist playlist,String emailid,String pname) {

        playlist.setEmailid(emailid);
        playlist.setPname(pname);
        return playlistRepository.insert(playlist);
    }
    @Override
    public Playlist addSongForPlaylist(Integer songid, Song song, String emailid, String pname) throws UserNotFoundException {
        if(playlistRepository.findById(pname).isPresent()){
            Playlist playlist =playlistRepository.findById(pname).get();
            Song song1  =songRepository.findById(songid).get();
            song1.setPname(pname);
            System.out.println(song1);
            List<Song> abc=playlist.getSonglist();
            abc.add(song1);
            playlist.setSonglist(abc);
            System.out.println(abc);
            return playlistRepository.save(playlist);
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public Boolean deletePlaylist(String pname) throws PlaylistNotFoundException {
        playlistRepository.deleteById(pname);
        return true;
    }
}
