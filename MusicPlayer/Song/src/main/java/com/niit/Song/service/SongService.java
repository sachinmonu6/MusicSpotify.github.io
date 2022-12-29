package com.niit.Song.service;

import com.niit.Song.domain.Song;
import java.util.List;

public interface SongService {
    public abstract Song addSong(Song song);
    public abstract List<Song> getAllSongs();
    public abstract  List<Song> getAllPSongs(String pname);

  public   Song getSongByName(String songName);
}
