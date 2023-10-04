package com.example.bookmyshow.dto;

import com.example.bookmyshow.model.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieDTO {
    private Long id;

    private String name;

    private String poster;

    private String trailer;

    private String description;

    public MovieDTO(Movie movie){
        this.id=movie.getId();
        this.name=movie.getName();
        this.poster=movie.getPoster();
        this.trailer=movie.getTrailer();
        this.description=movie.getDescription();
    }

}
