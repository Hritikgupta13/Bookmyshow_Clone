import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form = new FormGroup({
    email : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  })

  constructor(private movieService:MovieService, private router:Router, private route:ActivatedRoute){

  }
  // ngOnInit(): void {
  //  // this.loginUser()
  //   this.customerId();
  // }

  loginUser():void
  {
    this.movieService.login(this.form.value.email, this.form.value.password)
    .subscribe((data => {
      
        if(data.msg=="INVALID_USER")
        {
          alert(data.msg)
          localStorage.removeItem("loggedIn")
          this.router.navigate(['/login'])
          this.form.reset();
        }
        else{
          this.movieService.loginAuth().then(()=>{
            this.router.navigate(['/allmovies'])
          })
        }

    }))
    
  }

  customerId()
  {
    this.movieService.getCustomerId(this.form.value.email, this.form.value.password)
    .subscribe((data => {
      
        localStorage.setItem("customerId", data.id)
        sessionStorage.setItem("name", data.name)
        //console.log(data.id)

    }))
  }

  // onSubmit()
  // {
  //  if(this.form.valid){
  //   this.movieService.login(this.form.value.email, this.form.value.password)
  //   .subscribe((data => {
      
  //       alert(data.msg);
        // if(data.msg=="LOGIN_SUCCESSFULL")
        // {
          // this.router.navigate(['/allmovies'])
        // }
        // this.goToMovieList();
        //console.log(data.msg)

    // }))
    // console.log(this.form.value.email)
    // console.log(this.form.value.password)
    //localStorage.setItem('moviessss',JSON.stringify(this.form.value));
    
  //  }
  // }


//    if(userloggedin == true )
// {
//   $rootscope.loggedinuser = true
// }

}
