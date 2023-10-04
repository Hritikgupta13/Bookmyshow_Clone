package com.example.bookmyshow.data;

import com.example.bookmyshow.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    Theater findTheatreByNameAndCity(String name, String city );

    Theater findById(long id);
}