package com.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingTickets;
import com.bookingservice.repository.BookingTicketsRepository;

import java.util.List;

@Service
public class BookingTicketsService {

    @Autowired
    private BookingTicketsRepository bookingTicketsRepository;

    public List<BookingTickets> getAllBookingTickets() {
        return bookingTicketsRepository.findAll();
    }

    public BookingTickets getBookingTicketsById(int bookingTicketsId) {
        return bookingTicketsRepository.findById(bookingTicketsId).orElse(null);
    }

    public BookingTickets createBookingTickets(BookingTickets bookingTickets) {
        return bookingTicketsRepository.save(bookingTickets);
    }

    public BookingTickets updateBookingTickets(int bookingTicketsId, BookingTickets bookingTickets) {
        if (bookingTicketsRepository.existsById(bookingTicketsId)) {
            bookingTickets.setId(bookingTicketsId);
            return bookingTicketsRepository.save(bookingTickets);
        } else {
            return null;
        }
    }

    public void deleteBookingTickets(int bookingTicketsId) {
        bookingTicketsRepository.deleteById(bookingTicketsId);
    }
}
