package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.data.*;
import com.example.bookmyshow.exception.CustomerNotFoundException;
import com.example.bookmyshow.exception.InvalidBookingException;
import com.example.bookmyshow.exception.SeatUnavailableException;
import com.example.bookmyshow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMyShowServiceImpl implements BookMyShowService {

    public static final String BOOKING_CONFIRMED = "Booking Confirmed.";
    public static final String SEATS_UNAVAILABLE = "Seats Unavailable.";
    public static final String RESERVATION_SUCCESSFUL = "Reservation Successful.";
    public static final String INVALID_BOOKING = "Invalid Booking.";
    public static final int SEAT_COST = 100;
    public static final String CUSTOMER_NOT_FOUND = "Customer Not Found";

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
    BookingRepository bookingRepository;



    @Value("${theater.seat.basic.price}")
    private BigDecimal basicPrice;

    @Value("${theater.seat.premium.price}")
    private BigDecimal premiumPrice;

    @Transactional
     public List<ShowDTO> findAllShowsByMovieAndDateAndCity(String moviename, LocalDate date, String city){
        List<Show> shows = showRepository.findAllShowsNative(moviename, date, city);
        return shows.stream().map((show -> new ShowDTO(show))).collect(Collectors.toList());
    }

     public List<ShowSeatDTO> findAllAvailableSeatsForShow(Long showid){
         List<ShowSeat> showSeats = showSeatRepository.findAllNonPendingNonConfirmedShowSeatsNative(showid, ShowSeat.BookingStatus.CONFIRMED.toString(), ShowSeat.BookingStatus.RESERVED_PAYMENT_PENDING.toString());
         List<ShowSeatDTO> collect = showSeats.stream().map(showSeat -> new ShowSeatDTO(showSeat)).collect(Collectors.toList());
         return collect;
     }

     @Transactional
     public AbstractMap.SimpleEntry reserveSeats(BookingRequest bookingRequest){
         List<ShowSeat> showSeats = showSeatRepository.findAllById(bookingRequest.getSeats());

         try{
             validateReservation(showSeats);

             Customer customer = customerRepository.findById(bookingRequest.getCustomerId()).orElseThrow(CustomerNotFoundException::new);
             Booking booking = new Booking();
              booking.setBookedBy(customer);
             booking.setTotalAmount(getPaymentAmount(showSeats, bookingRequest));
             booking = bookingRepository.save(booking);
             for(ShowSeat showSeat: showSeats) {
                 showSeat.setBooking(booking);
                 showSeat.setStatus(ShowSeat.BookingStatus.RESERVED_PAYMENT_PENDING);
                 showSeat.setReservationTime(LocalDateTime.now());
             };
             return new AbstractMap.SimpleEntry("msg", RESERVATION_SUCCESSFUL);
         }catch (SeatUnavailableException e) {
             return new AbstractMap.SimpleEntry("msg", SEATS_UNAVAILABLE);

         } catch (CustomerNotFoundException e) {
             return new AbstractMap.SimpleEntry("msg", CUSTOMER_NOT_FOUND);

         }
     }

    private BigDecimal getPaymentAmount(List<ShowSeat> showSeats, BookingRequest bookingRequest) {
         BigDecimal total = new BigDecimal(0);
         for(ShowSeat showSeat: showSeats){
             ShowSeat.SeatType seatType = showSeat.getSeatType();
             switch (seatType){
                 case BASIC:
                    total = total.add(basicPrice);
                     break;
                 case PREMIUM:
                     total = total.add(premiumPrice);
                     break;
             }
         }
        return total;
    }

    private void validateReservation(List<ShowSeat> showSeats) throws SeatUnavailableException {
        if(CollectionUtils.isEmpty(showSeats) || showSeats.stream().anyMatch(showSeat -> showSeat.getStatus()!=ShowSeat.BookingStatus.UNRESERVED)){
            throw new SeatUnavailableException();
        }
    }

    @Transactional
     //called once payment is done or session times out
     public AbstractMap.SimpleEntry confirmSeats(BookingRequest bookingRequest){
         List<ShowSeat> showSeats = showSeatRepository.findAllById(bookingRequest.getSeats());
        try {
            validateSeats(showSeats);
            validateBooking(showSeats, bookingRequest);
            for(ShowSeat showSeat: showSeats){
                showSeat.setStatus(ShowSeat.BookingStatus.CONFIRMED);
            }
            return bookingConfirmedMessage(showSeats);
        } catch (SeatUnavailableException e) {
            return new AbstractMap.SimpleEntry("msg",SEATS_UNAVAILABLE);
        } catch (InvalidBookingException e) {
            return new AbstractMap.SimpleEntry ("msg", INVALID_BOOKING);
        }
    }

    @Override
    public List<MovieDTO> getallmovies() {
        List<Movie> movies =  movieRepository.findAll();
        return movies.stream().map((movie -> new MovieDTO(movie))).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getmoviebyName(String name) {
        Movie movie = movieRepository.findByName(name);
        return new MovieDTO(movie);

    }


    private AbstractMap.SimpleEntry bookingConfirmedMessage(List<ShowSeat> showSeats) {
        return new AbstractMap.SimpleEntry ("msg", BOOKING_CONFIRMED + ". Your booking ID is : " + showSeats.get(0).getBooking().getId() + ". Your seats : "+ showSeats.stream().map(showSeat -> showSeat.getId()).collect(Collectors.toList()));
    }

    private void validateBooking(List<ShowSeat> showSeats, BookingRequest bookingRequest) throws InvalidBookingException {
        for(ShowSeat showSeat: showSeats){
            if(showSeat.getBooking().getBookedBy().getId() != bookingRequest.getCustomerId()){
                throw new InvalidBookingException();
            }
        }
    }

    private void validateSeats(List<ShowSeat> showSeats) throws SeatUnavailableException {
        for(ShowSeat showSeat: showSeats){
            if(ShowSeat.BookingStatus.RESERVED_PAYMENT_PENDING!=showSeat.getStatus()){
                throw new SeatUnavailableException();
            }


        }
    }

    @Override
    public boolean CustomerVerification(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail()))
        {
            Customer currentcustomer = customerRepository.findByEmail(customer.getEmail());
            if (currentcustomer.getPassword().equals(customer.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

//    @Override
//    public Customer getCustomerDetails(String email) {
//        Customer customer = CustomerRepository.findByEmail(email);
//        return new Customer(email);
//
//    }

    @Override
    public CustomerDTO CustomerValidation(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail()))
        {
            Customer currentcustomer = customerRepository.findByEmail(customer.getEmail());
            if (currentcustomer.getPassword().equals(customer.getPassword())) {
                return new CustomerDTO(currentcustomer);
            } else {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

}
