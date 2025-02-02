package com.bookingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.BookingTickets;


@Repository
public interface BookingTicketsRepository extends JpaRepository<BookingTickets, Integer> {
	
}
