import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { isEmpty } from 'rxjs';
import { MovieService } from '../movie.service';
import { MovieShows } from '../movieShows';


@Component({
  selector: 'app-movies-shows',
  templateUrl: './movies-shows.component.html',
  styleUrls: ['./movies-shows.component.css']
})
export class MoviesShowsComponent implements OnInit {
  data: any;
  movieShows: MovieShows[];
  responseData: any;
  name: any;
  city: any;
  date: any;
  seatType: any;
  selectedValue: any;
  startTime:any;
  someArray:[]=[];
  constructor(private movieService: MovieService,private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params.name;
    this.city = this.route.snapshot.params.city;
    this.date = this.route.snapshot.params.date;
    this.allMovieShows();
    localStorage.setItem('City', this.city);
    localStorage.setItem('Date', this.date);
  }

  allMovieShows() {
    this.movieService.getMovieShows(this.name, this.date, this.city).subscribe(res => {
      this.movieShows = res; 
    });

  }

  onDropdownChange(event: any) {
    this.seatType = event.target.value;

  }



 routeTo(id, theaterName)
 {
      this.router.navigate(['/selectshows/'+id]);
      localStorage.setItem("Theater Name", theaterName);

 }

}
