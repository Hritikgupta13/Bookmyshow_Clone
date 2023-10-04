package com.example.bookmyshow.data;

import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {



    @Query(value = "SELECT ss.* FROM SHOW_SEAT ss where ss.show_id=?1 and ss.status NOT IN (?2,?3)", nativeQuery = true)
    List<ShowSeat> findAllNonPendingNonConfirmedShowSeatsNative(Long showid, String status1, String status2);

    List<ShowSeat> findAllByStatusIs(ShowSeat.BookingStatus status);

}