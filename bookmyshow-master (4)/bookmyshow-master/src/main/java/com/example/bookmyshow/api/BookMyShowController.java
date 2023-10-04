package com.example.bookmyshow.api;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.model.Customer;
import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.service.BookMyShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Optional;

import static com.example.bookmyshow.model.Customer.LoginStatus.LOGIN_SUCCESSFULL;
import static com.example.bookmyshow.model.Customer.LoginStatus.INVALID_USER;

@RestController
@RequestMapping("/bms")
public class BookMyShowController {

    @Autowired
    BookMyShowService bookMyShowService;

    @GetMapping(path = "/movieshows/{moviename}/{date}/{city}")
    public List<ShowDTO> shows(@PathVariable String moviename, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable String city) {

        return bookMyShowService.findAllShowsByMovieAndDateAndCity(moviename, date, city);
    }

    @GetMapping(path = "/showseats/{id}")
    public List<ShowSeatDTO> showSeats(@PathVariable long id){
        return bookMyShowService.findAllAvailableSeatsForShow(id);
    }

    @PostMapping(path = "/reserveseats", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Object bookSeats(@RequestBody BookingRequest bookingRequest){
        return bookMyShowService.reserveSeats(bookingRequest);
    }

    @PostMapping(path = "/confirmseats", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object conSeats(@RequestBody BookingRequest bookingRequest){
        return bookMyShowService.confirmSeats(bookingRequest);
    }

    @GetMapping(path = "/allmovies")
    public List<MovieDTO> getmovies() {
        return bookMyShowService.getallmovies();
    }
    @GetMapping("/movie/{name}")
    public MovieDTO getmovie(@PathVariable String name){
        return bookMyShowService.getmoviebyName(name);
    }

//    @PostMapping(path = "/CustomerLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Object CustomerLogin(@RequestBody Customer customer){
//        if(bookMyShowService.CustomerValidation(customer)== false){
//            return new AbstractMap.SimpleEntry ("msg", WRONG_PASSWORD);
//        }
//        else
//            return new AbstractMap.SimpleEntry ("msg", LOGIN_SUCCESSFULL);
//    }
//}
@PostMapping(path = "/CustomerLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.CREATED)
public CustomerDTO CustomerLogin(@RequestBody Customer customer){
    CustomerDTO customerDTO = bookMyShowService.CustomerValidation(customer);
    if( customerDTO == null){

        return null;}
    else
        return customerDTO ;
}

    @PostMapping(path = "/CustomerVerification", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Object CustomerVerification(@RequestBody Customer customer){
        if(bookMyShowService.CustomerVerification(customer)== false){
            return new AbstractMap.SimpleEntry ("msg", INVALID_USER);
        }
        else
            return new AbstractMap.SimpleEntry ("msg", LOGIN_SUCCESSFULL);
    }
}


