import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit{
  movie:any
  theatre:any
  date:any
  seatNumber:any
  city:any
  rd:Array<any> = [];
  customerId:any
  stringArray=[];
  numberArray = [];
  constructor(private movieService: MovieService, private route: ActivatedRoute, public router: Router){}
  
  ngOnInit(): void {
    this.city=localStorage.getItem("City") ;
    this.movie=localStorage.getItem("Movie Name");
    this.theatre=localStorage.getItem("Theater Name");
    this.date=localStorage.getItem("Date");
    this.seatNumber=localStorage.getItem("Seat number");
    this.customerId=localStorage.getItem("customerId")
  }
  
  

  getseatId(seatNumber)
  {
    
    // if (this.rd.indexOf(seatNumber) > -1) {
    //   this.rd.splice(this.rd.indexOf(seatNumber),1);
    // }else{
    //   this.rd.push(seatNumber);
    // }
    // this.someArray = this.seatNumber.split(",");
    // for (let i=0;i<this.rd.length;i++)
    // {
    //   this.rd[i]=parseInt(this.someArray[i])
    // }
  //   this.stringArray=this.seatNumber.split(",")
  //   length = [seatNumber].length;

  this.rd=JSON.parse(this.seatNumber)
  }
  getData(data:any)
  {
      //console.log(data)
      console.log(this.rd)
      //console.log(this.rd)
    this.movieService.confirmBooking(JSON.parse(this.seatNumber),this.customerId)
    .subscribe((res)=>{
      alert(res.msg);

    })

  }


}
