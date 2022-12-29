package com.niit.Song.service;

import com.niit.Song.domain.Playlist;
import com.niit.Song.domain.Song;
import com.niit.Song.exception.PlaylistNotFoundException;
import com.niit.Song.exception.UserNotFoundException;
import java.util.List;

public interface PlaylistService {
    public abstract List<Playlist> getAllPlaylists(String emailid) throws PlaylistNotFoundException;
    public abstract Playlist addList(Playlist playlist,String email,String pname);
    public abstract Playlist addSongForPlaylist(Integer songid, Song song, String email, String pname)throws UserNotFoundException;
    public abstract Boolean deletePlaylist(String pname) throws PlaylistNotFoundException;

}