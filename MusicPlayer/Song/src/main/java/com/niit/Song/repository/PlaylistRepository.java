package com.niit.Song.repository;

import com.niit.Song.domain.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PlaylistRepository extends MongoRepository<Playlist,String> {
    public List<Playlist> findByEmailid(String email);

}