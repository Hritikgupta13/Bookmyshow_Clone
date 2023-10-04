package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.model.Customer;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;

public interface BookMyShowService {

    public List<ShowDTO> findAllShowsByMovieAndDateAndCity(String moviename, LocalDate date, String city);

    public List<ShowSeatDTO> findAllAvailableSeatsForShow(Long showid);

    public AbstractMap.SimpleEntry reserveSeats(BookingRequest bookingRequest);

    public AbstractMap.SimpleEntry confirmSeats(BookingRequest bookingRequest);

    public List<MovieDTO> getallmovies();

    public MovieDTO getmoviebyName(String name);

    public CustomerDTO CustomerValidation(Customer customer);

    boolean CustomerVerification(Customer customer);



}
