import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';



@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css'],
  
})



export class MovieListComponent implements OnInit{
  title = 'angular-frontend';

  
  movies: Movie[] = [];
  name:any;
  id:any;
  moviessss:any;
  



  constructor(private movieService: MovieService, public router: Router, private route:ActivatedRoute){}

  ngOnInit(): void {
    this.getMovies();
    //this.movieById();
   this.name=this.route.snapshot.params.name;

  }

  
  
  private getMovies(){
    this.movieService.getMoviesList().subscribe(data => {
      this.movies = data;
    });
    
  }

  // details(name)
  // {
  //   this.router.navigate(['/allmovies/'+name]);
  // }
 
  Search()
  {
    if(this.name=="")
    {
      this.ngOnInit();
    }
    else{
    this.movies=this.movies.filter(res =>{
      return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase())
    });
  }

  
  }
  // movieById()
  // {
  //   this.movieService.getMovieById(this.movies).subscribe(res=>{console.log(res);})
  // }
  // loadData()
  // {
  //   let xcx=localStorage.getItem('moviessss');
  //   this.router.navigate(['allmovies/'+this.moviessss.name]);
  // }

  // endBooking(id){
  //   return this.movieService.getMovieById(this.id)
  //   .subscribe(data => {this.movies = data}), this.router.navigate(['/addmovie'])
  //   }
  }
// key:string='id';

// reverse:boolean=false;
//   sort(key)
//   {
// this.key=key;
// this.reverse=!this.reverse;
//   }



 


