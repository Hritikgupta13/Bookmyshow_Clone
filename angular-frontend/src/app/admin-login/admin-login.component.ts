import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  form = new FormGroup({
    email : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  })

  constructor(private movieService:MovieService, private router:Router, private route:ActivatedRoute){

  }

  loginUser():void
  {
    this.movieService.adminLogin(this.form.value.email, this.form.value.password)
    .subscribe((data => {
      
        if(data.msg=="Either the admin doesn't exist or you have entered wrong password")
        {
          alert(data.msg)
          
          localStorage.removeItem("loggedIn")
          this.router.navigate(['/adminLogin'])
          this.form.reset();
        }
        else{
          this.movieService.loginAuth().then(()=>{
            this.router.navigate(['admin/addmovie'])
          })
        }

    }))
    
  }

}
