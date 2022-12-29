package com.niit.Song.service;

import com.niit.Song.domain.Playlist;
import com.niit.Song.domain.Song;
import com.niit.Song.repository.PlaylistRepository;
import com.niit.Song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Song addSong(Song song) {
        return songRepository.insert(song);
    }

    @Override

    public List<Song> getAllSongs()
    {
        System.out.println("\nFind all : " + songRepository.findAll());
        return songRepository.findAll();
    }

    @Override
    public List<Song> getAllPSongs(String pname) {
        Playlist playlist= playlistRepository.findById(pname).get();
        List<Song> abc=playlist.getSonglist();
        return abc;
    }

    @Override
    public Song getSongByName(String songName) {
        return songRepository.findBysongName(songName);
    }

}

