import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AuthGuard } from './auth.guard';
import { BookMovieComponent } from './book-movie/book-movie.component';
import { BookingComponent } from './booking/booking.component';
import { LoginComponent } from './login/login.component';



import { MovieListComponent } from './movie-list/movie-list.component';
import { MoviesShowsComponent } from './movies-shows/movies-shows.component';
import { SelectSeatsComponent } from './select-seats/select-seats.component';
import { selectSeats } from './selectSeats';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'allmovies', component:MovieListComponent, canActivate:[AuthGuard]},
  {path:'login', component:LoginComponent},
  {path:'signup', component:SignupComponent},
  {path:'admin/addmovie', component:AddMovieComponent, canActivate:[AuthGuard]},
  {path:'allmovies/:name', component:BookMovieComponent, canActivate:[AuthGuard]},
  {path:'movieshows/:name/:date/:city', component:MoviesShowsComponent, canActivate:[AuthGuard]},
  {path:'selectshows/:id', component:SelectSeatsComponent, canActivate:[AuthGuard]},
  {path:'booking',component:BookingComponent, canActivate:[AuthGuard]},
  {path:'adminLogin',component:AdminLoginComponent},
  {path:'', redirectTo:'login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
