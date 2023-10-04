import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking';
import { BookMovie } from '../bookMovie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-select-seats',
  templateUrl: './select-seats.component.html',
  styleUrls: ['./select-seats.component.css']
})
export class SelectSeatsComponent implements OnInit{
  
  id: any;
  selectShows: import("c:/Users/kb57/angular-frontend/src/app/selectSeats").selectSeats[];
  users: import("c:/Users/kb57/angular-frontend/src/app/movie").Movie[];
  data: any;
  seatId:any;
  arr=[];
  rd:Array<any> = [];

  ghg:any;
  customerId: string;

constructor(private movieService: MovieService, private route: ActivatedRoute, public router: Router){}
  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.selectedShows();
    this.customerId=localStorage.getItem("customerId")
    // this.movieService.getMoviesList().subscribe((data)=>{this.users=data})
  }
  
selectedShows() {
    this.movieService.getSelectedShows(this.id).subscribe(res => {
      this.selectShows = res; 
    });
  }

  routeTo()
  {
      //  this.router.navigate(['/booking']);
 
  }

  getseatId(seatId)
  {
    
    if (this.rd.indexOf(seatId) > -1) {
      this.rd.splice(this.rd.indexOf(seatId),1);
    }else{
      this.rd.push(seatId);
    }
//     const cxx=Object.entries(seatId)

//     //console.log(cxx.length)
//     for (let i = 0; i < cxx.length; i++)
//     {
      
//     if(cxx[i][1]==true)
//     {
//       this.arr.push(cxx[i][0])
      
//     }
//     function removeDuplicates(arr) {
//       return arr.filter((item,
//           index) => arr.indexOf(item) === index);
      
//     }
//     // console.clear()
//     //   console.log(removeDuplicates(this.arr))
//     this.rd =removeDuplicates(this.arr)
    
//     }
// //     for(let i=0;i<=14;i++)
//     // {
//       //console.log(cxx)
// //     }
// // return this.arr
// console.log(this.rd)
//       return [this.rd]
  }

  getData(data:any)
  {
      console.log(data)
    //   this.movieService.bookSeats(data)
    // .subscribe((data => {
      
    //     alert("Movie Added");
    //     this.router.navigate(['/booking']);

    // }))
    this.movieService.bookSeats(this.rd,this.customerId)
    .subscribe((res)=>{
      alert(res.msg);
      this.router.navigate(['/booking']);

    })
localStorage.setItem("Seat number",JSON.stringify(this.rd));

//localStorage.setItem("Customer ID",data.customerId);

  }

  // saveSeat()
  // {
  //     this.movieService.bookSeats(this.seatId,this.data)
  //   .subscribe((res => {
      
  //       alert("Movie Added");
  //       this.router.navigate(['/booking']);

  //   }))
  // }

}
