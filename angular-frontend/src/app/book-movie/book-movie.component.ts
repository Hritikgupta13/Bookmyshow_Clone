import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookMovie } from '../bookMovie';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-book-movie',
  templateUrl: './book-movie.component.html',
  styleUrls: ['./book-movie.component.css']
})
export class BookMovieComponent implements OnInit{
  bookMovie:BookMovie;
  id:any;
  name:any;
  data:any;
  selectedValue: any;
  city: any;
  date: any;
  constructor(private movieService: MovieService, private route:ActivatedRoute, public router: Router){
    // this.bookMovie.poster = "https://www.dreamstime.com/transparent-pattern-background-simulation-alpha-channel-png-seamless-gray-white-squares-vector-design-grid-image162521286"
  }

  ngOnInit(): void {
    this.name=this.route.snapshot.params.name;
    this.movieById();
    localStorage.setItem('Movie Name', this.name);
  }
  movieById()
  {
    this.movieService.getMovieById(this.name).subscribe(res=>{
      this.data=res; 
      this.bookMovie=this.data;
  
    });
  }
  onDropdownChange(event: any) {
    if(event.target.value===undefined)
    {
      alert("please select City");
      
    }
    else
    {
    this.city = event.target.value;
    console.log(this.city);
    }
  }

  onClickOfDate(event:any)
  {
    if(event.target.value==="")
    {
      alert("please select date");
      
    }
    else{
    this.date = event.target.value;
    console.log(this.date);
    }
  }

  routeTo(name, date, city)
  {
    if(this.date ===undefined || this.city ===undefined)
    {
      if(this.date===undefined)
      {
      alert("please select date");
      }
      else if(this.city===undefined){
        alert("please select city")
      }
    }
    else{
    this.router.navigate(['/movieshows/'+name+'/'+date+'/'+city]);
    }
  }
}
