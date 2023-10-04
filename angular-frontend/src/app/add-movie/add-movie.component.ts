import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MovieService } from '../movie.service';
import {Movie} from "../movie";
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})

export class AddMovieComponent implements OnInit{
  form = new FormGroup({
    name : new FormControl('', Validators.required),
    poster: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    trailer: new FormControl('', Validators.required),
  })

  constructor(private movieService:MovieService, private router:Router){

  }

  movie:Movie[];

  ngOnInit(): void{

    this.saveMovie();
  }

  

  goToMovieList()
  {
    this.router.navigate(['/addmovie']);
  }

  onSubmit()
  {
    this.movieService.addMovie(this.form.value.name, this.form.value.poster, this.form.value.description, this.form.value.trailer)
    .subscribe((data => {
      
        alert("Movie Added");
        this.form.reset();
        this.goToMovieList();

    }))
    //localStorage.setItem('moviessss',JSON.stringify(this.form.value));
    
   }

   saveMovie(){
    
    return this.movieService.getMoviesList().subscribe(data => this.movie = data);
    

  }
  }



