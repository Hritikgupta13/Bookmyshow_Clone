import { Movie } from "./movie";

export class MovieShows {

    id: number;
    date: any;
    startTime: any;
    movie: Movie;
    theater: Theater
}


class Theater {
    id: number;
    name: string;
    city: string;
    premiumSeats: number;
    basicSeats: number;
    address: { street: string, pincode: number }
}

