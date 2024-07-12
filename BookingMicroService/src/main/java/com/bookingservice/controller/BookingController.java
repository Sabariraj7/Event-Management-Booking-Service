package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingservice.dto.BookingDTO;
import com.bookingservice.dto.BookingDetailsDTO;
import com.bookingservice.entity.Booking;
import com.bookingservice.service.BookingService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookingmicroservice/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getall")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Map<String, Object> getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping("/add")
    public Map<String, Object> createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/update/{bookingId}")
    public Map<String, Object> updateBooking(@PathVariable int bookingId, @RequestBody Booking booking) {
        return bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/delete/{bookingId}")
    public Map<String, Object> deleteBooking(@PathVariable int bookingId) {
        return bookingService.deleteBooking(bookingId);
    }
    @PostMapping("/addBookingWithTicket")
    public Map<String, Object> addBookingWithTicket(@RequestBody BookingDTO bookingDTO) {
        return bookingService.addBookingWithTicket(bookingDTO);
    }

    @GetMapping("/details")
    public List<BookingDetailsDTO> getAllBookingDetails() {
        return bookingService.getBookingDetails();
    }
}


//package com.bookingservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.bookingservice.dto.BookingDetailsDTO;
//import com.bookingservice.entity.Booking;
//import com.bookingservice.service.BookingService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @GetMapping("/getall")
//    public List<Booking> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//
//    @GetMapping("/{bookingId}")
//    public Booking getBookingById(@PathVariable int bookingId) {
//        return bookingService.getBookingById(bookingId);
//    }
//
//    @PostMapping("/add")
//    public Booking createBooking(@RequestBody Booking booking) {
//        return bookingService.createBooking(booking);
//    }
//
//    @PutMapping("/update/{bookingId}")
//    public String updateBooking(@PathVariable int bookingId, @RequestBody Booking booking) {
//        return bookingService.updateBooking(bookingId, booking);
//    }
//
//    @DeleteMapping("/delete/{bookingId}")
//    public String deleteBooking(@PathVariable int bookingId) {
//        return bookingService.deleteBooking(bookingId);
//    }
	//@PostMapping("/addBookingWithTicket")
	//public Map<String, Object> addBookingWithTicket(
	//      @RequestParam(required = false) Integer eventId,
	//      @RequestParam(required = false) Integer userId,
	//      @RequestParam(required = false) Integer numberOfTickets
	//) {
	//  if (eventId == null || userId == null || numberOfTickets == null) {
	//      Map<String, Object> response = new HashMap<>();
	//      response.put("status", "error");
	//      response.put("message", "Please provide all the required parameters (eventId, userId, numberOfTickets)");
	//      return response;
	//  }
	//  return bookingService.addBookingWithTicket(eventId, userId, numberOfTickets);
	//}
//
//    @PostMapping("/addBookingWithTicket")
//    public String addBookingWithTicket(
//            @RequestParam(required = false) Integer eventId,
//            @RequestParam(required = false) Integer userId,
//            @RequestParam(required = false) Integer numberOfTickets
//    ) {
//        if (eventId == null || userId == null || numberOfTickets == null) {
//            return "Error: Please provide all the required parameters (eventId, userId, numberOfTickets)";
//        }
//        return bookingService.addBookingWithTicket(eventId, userId, numberOfTickets);
//    }
//    
//    @GetMapping("/details")
//    public List<BookingDetailsDTO> getAllBookingDetails() {
//        return bookingService.getBookingDetails();
//    }
//}






