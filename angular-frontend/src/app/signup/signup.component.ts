import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    email : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  })

  constructor(private movieService:MovieService, private router:Router){

  }

  onSubmit()
  {
    this.movieService.signup(this.form.value.name, this.form.value.email, this.form.value.password)
    .subscribe((data => {
      
        alert(data.msg);
        if(data.msg=="CUSTOMER_SAVED" || "CUSTOMER_ALREADY_EXIST")
        {
          this.router.navigate(['/login'])
        }


    }))

    
   }

}
