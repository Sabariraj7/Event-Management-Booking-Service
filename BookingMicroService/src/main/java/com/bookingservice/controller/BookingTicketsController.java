package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingservice.entity.BookingTickets;
import com.bookingservice.service.BookingTicketsService;

import java.util.List;

@RestController
@RequestMapping("/booking-tickets")
public class BookingTicketsController {

    @Autowired
    private BookingTicketsService bookingTicketsService;

    @GetMapping("/getall")
    public List<BookingTickets> getAllBookingTickets() {
        return bookingTicketsService.getAllBookingTickets();
    }

    @GetMapping("/{bookingTicketsId}")
    public BookingTickets getBookingTicketsById(@PathVariable int bookingTicketsId) {
        return bookingTicketsService.getBookingTicketsById(bookingTicketsId);
    }

    @PostMapping("/add")
    public BookingTickets createBookingTickets(@RequestBody BookingTickets bookingTickets) {
        return bookingTicketsService.createBookingTickets(bookingTickets);
    }

    @PutMapping("/update/{bookingTicketsId}")
    public BookingTickets updateBookingTickets(@PathVariable int bookingTicketsId, @RequestBody BookingTickets bookingTickets) {
        return bookingTicketsService.updateBookingTickets(bookingTicketsId, bookingTickets);
    }

    @DeleteMapping("/delete/{bookingTicketsId}")
    public void deleteBookingTickets(@PathVariable int bookingTicketsId) {
        bookingTicketsService.deleteBookingTickets(bookingTicketsId);
    }
}
