package com.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingservice.dto.BookingDetailsDTO;
import com.bookingservice.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
	@Procedure(procedureName = "booking_and_seat_allocation")
    List<Object[]> addBookingWithTicket(
            @Param("p_event_id") int eventId,
            @Param("p_user_id") int userId,
            @Param("p_number_of_tickets") int numberOfTickets,
            @Param("v_booking_id") Integer bookingId // Define v_booking_id as an output parameter
    );

    @Query("SELECT new com.bookingservice.dto.BookingDetailsDTO(" +
            "    b.id, " +
            "    u.userName, " +
            "    u.phone, " +
            "    e.eventName, " +
            "    h.hallName, " +
            "    h.location, " +
            "    e.eventDate, " +
            "    b.numberOfTickets, " +
            "    b.totalPrice, " +
            "    b.offeredPrice) " +
            "FROM Booking b " +
            "INNER JOIN b.event e " +
            "INNER JOIN e.hall h " +
            "INNER JOIN b.user u")
    List<BookingDetailsDTO> getBookingDetails();
}



//package com.bookingservice.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.bookingservice.dto.BookingDetailsDTO;
//import com.bookingservice.entity.Booking;
//
//@Repository
//public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    
//    @Procedure(procedureName = "booking_and_seat_allocation")
//    List<Object> addBookingWithTicket(
//        @Param("p_event_id") int eventId,
//        @Param("p_user_id") int userId,
//        @Param("p_number_of_tickets") int numberOfTickets
//    );
//    @Query("SELECT new com.bookingservice.dto.BookingDetailsDTO(" +
//    		"    b.id, "+
//            "    u.userName, " +
//            "    u.phone, " +
//            "    e.eventName, " +
//            "    h.hallName, " +
//            "    h.location, " +
//            "    e.eventDate, " +
//            "    b.numberOfTickets, " +
//            "    b.totalPrice, " +
//            "    b.offeredPrice) " +
//            "FROM Booking b " +
//            "INNER JOIN b.event e " +
//            "INNER JOIN e.hall h " +
//            "INNER JOIN b.user u")
//     List<BookingDetailsDTO> getBookingDetails();
//}
