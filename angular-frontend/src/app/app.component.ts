import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from './movie.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  //title = 'angular-frontend';
  menuType:String='default';
  name:string=sessionStorage.getItem('name')

    constructor(private movieService:MovieService, private router:Router, private route:ActivatedRoute){
  
    }
  ngOnInit(): void {
    this.router.events.subscribe((val:any) =>{
      if(val.url){
        if(localStorage.getItem('loggedIn'))
        {
          this.menuType='default';
          
           
          
        }
        
        else
        {
          this.menuType="logged";
        }
      }
    })
   
}
  logout()
  {
    localStorage.removeItem('loggedIn');
    this.router.navigate(['/login']);

  }

  }
