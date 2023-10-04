package com.example.bookmyshow.service;

import com.example.bookmyshow.model.*;

import java.util.List;

public interface AdminService {
    void addTheaters(List<Theater> theaters);

    void addMovies(List<Movie> movies);

    void addShows(List<Show> shows);

    void addCustomers(Customer customers);

    boolean customerExist(String email);

    boolean adminValidation(Admin admin);

    Theater getTheatreByNameandCity(String name,String city);
}
