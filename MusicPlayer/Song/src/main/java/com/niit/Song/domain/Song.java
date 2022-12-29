package com.niit.Song.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Song {
    @Id
    private Integer songId;
    private String songName;
    private String artist;
    private String releaseYear;
    private String pname;
}