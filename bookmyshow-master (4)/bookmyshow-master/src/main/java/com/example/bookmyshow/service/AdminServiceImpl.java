package com.example.bookmyshow.service;

import com.example.bookmyshow.data.*;
import com.example.bookmyshow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    AdminRepository adminRepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public void addTheaters(List<Theater> theaters) {
        for (Theater theater : theaters) {
            theaterRepository.save(theater);
        }
    }

    @Override
    public void addMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            movieRepository.save(movie);
        }
    }

    @Override
    @Transactional
    public void addShows(List<Show> shows) {
        for (Show show : shows) {

            Show savedShow = showRepository.save(show);

            Theater theatre = theaterRepository.findById(savedShow.getTheater().getId().longValue());

            for(int i = 0; i< theatre.getBasicSeats(); i++){
                ShowSeat showSeat = new ShowSeat();
                showSeat.setShow(savedShow);
                showSeat.setTheater(savedShow.getTheater());
                showSeat.setSeatType(ShowSeat.SeatType.BASIC);
                showSeatRepository.save(showSeat);}

            for(int i = 0; i< theatre.getPremiumSeats(); i++){
                ShowSeat showSeat = new ShowSeat();
                showSeat.setShow(savedShow);
                showSeat.setTheater(savedShow.getTheater());
                showSeat.setSeatType(ShowSeat.SeatType.PREMIUM);
                showSeatRepository.save(showSeat);}
        }
    }


    @Override
    public void addCustomers(Customer customer) {

        customerRepository.save(customer);

    }

    public boolean customerExist(String email) {
        return customerRepository.existsByEmail(email);
    }

    public boolean adminValidation(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {
            Admin currentadmin = adminRepository.findByEmail(admin.getEmail());
            if (currentadmin.getPassword().equals(admin.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Theater getTheatreByNameandCity(String name, String city) {
        return theaterRepository.findTheatreByNameAndCity(name,city);
    }
}
