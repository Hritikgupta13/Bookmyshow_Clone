package com.example.bookmyshow.api;

import com.example.bookmyshow.model.*;
import com.example.bookmyshow.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;

import static com.example.bookmyshow.model.Customer.LoginStatus.CUSTOMER_ALREADY_EXIST;
import static com.example.bookmyshow.model.Customer.LoginStatus.CUSTOMER_SAVED;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(path = "/theaters", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTheater(@RequestBody List<Theater> theaters){
        adminService.addTheaters(theaters);
    }

    @PostMapping(path = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovies(@RequestBody List<Movie> movies){
        adminService.addMovies(movies);
    }

    @PostMapping(path = "/shows", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addShows(@RequestBody List<Show> shows){
        adminService.addShows(shows);
    }

    @PostMapping(path = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Object addCustomers(@RequestBody Customer customer ){
        if(adminService.customerExist(customer.getEmail()) == false){
        adminService.addCustomers(customer);
        return new AbstractMap.SimpleEntry ("msg",CUSTOMER_SAVED);}
        else
            return new AbstractMap.SimpleEntry ("msg",CUSTOMER_ALREADY_EXIST);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Object adminLogin(@RequestBody Admin admin){
        if(adminService.adminValidation(admin)== false){
            return new AbstractMap.SimpleEntry ("msg", "Either the admin doesn't exist or you have entered wrong password");}
        else
            return new AbstractMap.SimpleEntry ("msg", "Login confirmed");
        }
    @GetMapping(value = "/TheatreSearch/{name}/{city}")
    @ResponseStatus(HttpStatus.FOUND)
    public Theater getTheatre(@PathVariable String name, @PathVariable String city){

        return adminService.getTheatreByNameandCity(name,city);
    }



    }



