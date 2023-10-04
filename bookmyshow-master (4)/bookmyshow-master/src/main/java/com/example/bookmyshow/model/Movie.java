package com.example.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", initialValue = 1, allocationSize=1)
    private Long id;

    private String name;

    private String poster;

    private String trailer;

    private String description;


    public Movie(Long movieid) {
        this.id = movieid;
    }

}