import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Booking } from './booking';
import { BookMovie } from './bookMovie';
import { Login } from './login';
import { Movie } from './movie';
import { MovieShows } from './movieShows';
import { selectSeats } from './selectSeats';


@Injectable({
  providedIn: 'root'
})

export class MovieService {

  private baseURL = "http://localhost:8080/bms/allmovies";
  movieForm: any;
  submitted: boolean;
  movieName:any;
  date:any;
  city:any;


  constructor(private http: HttpClient) { }

  loginAuth():Promise<any>
  {
    return new Promise((res)=>{
      localStorage.setItem('loggedIn', 'true');
      res(true);
    })
  }
  
  isLoginAuth():boolean
  {
    return !!localStorage.getItem('loggedIn');
  }

  getMoviesList(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.baseURL}`);
  }

  addMovie(name, poster, description, trailer){
     return this.http.post<any>("http://localhost:8080/admin/movies", [{name, poster, description, trailer}]);
  }

  getMovieById(name){
    return this.http.get<BookMovie>("http://localhost:8080/bms/movie/"+name);
  }

  
  getMovieShows(name,date,city){
    return this.http.get<MovieShows[]>("http://localhost:8080/bms/movieshows"+"/"+name+"/"+date+"/"+city);
  }

  getSelectedShows(showid){
    return this.http.get<selectSeats[]>("http://localhost:8080/bms/showseats"+"/"+showid);
  }


  bookSeats(seatId,customerId){
     return this.http.post<any>("http://localhost:8080/bms/reserveseats",{seats: seatId, customerId});
  }

  confirmBooking(seatId,customerId)
  {
    return this.http.post<any>("http://localhost:8080/bms/confirmseats",{seats: seatId, customerId});
  }

  login(email,password)
  {
    return this.http.post<any>("http://localhost:8080/bms/CustomerVerification",{email, password});
  }

  signup(name, email,password)
  {
    return this.http.post<any>("http://localhost:8080/admin/customers",{name, email, password});
  }

  getCustomerId(email,password)
  {
    return this.http.post<any>("http://localhost:8080/bms/CustomerLogin",{email, password});
  }

  adminLogin(email,password)
  {
    return this.http.post<any>("http://localhost:8080/admin/login",{email, password});
  }
}

