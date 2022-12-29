package com.niit.Song.repository;

import com.niit.Song.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongRepository extends MongoRepository<Song,Integer> {
    @Query("{'songName' : ?0}")
 public Song findBysongName(String songName);
}