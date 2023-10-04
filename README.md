# Group9-BookmyShow

Frontend

clone repository
switch to the frontend folder (cd /fronted)
npm install
ng serve
Backend

clone repository
open the backend folder in your IDE
change the database connectivity in application properties
run the application
APIs

1- ADD THEATER POST REQUEST URL - http://localhost:8080/admin/theaters JSON DATA [ { "name": "PVR", "city": "HYD", "premiumSeats": "20", "basicSeats": "40", "address": { "street": "FORUMMALL", "pincode": "500049" }

}, { "name": "AMB", "city": "HYD", "premiumSeats": "20", "basicSeats": "40", "address": { "street": "SUJANAMALL", "pincode": "500001" } } ]'

2- ADD MOVIE POST REQUEST URL- http://localhost:8080/admin/movies JSON DATA [ { "name": "THOR" }, { "name": "VIKRAM" } ]

3- ADD SHOW POST REQUEST URL - http://localhost:8080/admin/shows JSON DATA [ { "date": "2023-03-18", "startTime": "20:00:00", "movie": "2", "theater": "1", "auditorium": "1" }

]

4- CUSTOMER SIGNUP POST REQUEST URL - http://localhost:8080/admin/customers JSON DATA [ { "name": "John" }, { "name": "Jacob" } ]

5- SEATS AVAILABLE FOR SHOW ID GET REQUEST URL - http://localhost:8080/bms/showseats JSON DATA { "showid": 3 }

6- Get show available by movie, date & city GET REQUEST URL – http://localhost:8080/bms/movieshows JSON DATA { "moviename" : "THOR", "date": "2022-06-25", "city": "HYD" }

7- BOOK SEATS POST REQUEST URL - http://localhost:8080/bms/reserveseats JSON DATA { "seats": [ 1,2 ], "customerId": 1 }

8- Confirm booking(will act as payment done) POST REQUEST URL – http://localhost:8080/bms/confirmseats JSON DATA {

"seats": [ 1,2 ], "customerId": 1 }

9- Get movie by name GET REQUEST URL - http://localhost:8080/bms/movie/1

10- Admin login POST REQUEST URL – http://localhost:8080/admin/login JSON DATA { "email": "hritik78@gmail.com", "password": "test1234" }

11- Get Theatre by name and city GET REQUEST URL – http://localhost:8080/admin/TheatreSearch/AMB/HYD JSON DATA

12- Movies list GET REQUEST URL – http://localhost:8080/bms/allmovies JSON DATA

13- Customer Login POST REQUEST URL - http://localhost:8080/bms/CustomerLogin JSON DATA { "email": "hritik1256@gmail.com", "password": "test124" }
