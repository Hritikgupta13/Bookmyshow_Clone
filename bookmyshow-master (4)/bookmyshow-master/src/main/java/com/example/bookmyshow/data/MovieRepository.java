package com.example.bookmyshow.data;

import com.example.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByName(String name);
}