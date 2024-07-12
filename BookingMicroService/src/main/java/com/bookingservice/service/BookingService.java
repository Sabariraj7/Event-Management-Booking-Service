package com.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.dto.BookingDTO;
import com.bookingservice.dto.BookingDetailsDTO;
import com.bookingservice.entity.Booking;
import com.bookingservice.repository.BookingRepository;

import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Map<String, Object> getBookingById(int bookingId) {
        Map<String, Object> response = new HashMap<>();
        try {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new Exception("Booking not found"));
            response.put("status", "success");
            response.put("data", booking);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> createBooking(Booking booking) {
        Map<String, Object> response = new HashMap<>();
        try {
            Booking createdBooking = bookingRepository.save(booking);
            response.put("status", "success");
            response.put("data", createdBooking);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> updateBooking(int bookingId, Booking booking) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (bookingRepository.existsById(bookingId)) {
                booking.setId(bookingId); // Ensure the booking ID is set
                bookingRepository.save(booking);
                response.put("status", "success");
                response.put("message", "Booking updated successfully");
            } else {
                response.put("status", "error");
                response.put("message", "Booking id not found, please provide a correct id to update");
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error updating booking: " + e.getMessage());
        }
        return response;
    }

    public Map<String, Object> deleteBooking(int bookingId) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (bookingRepository.existsById(bookingId)) {
                bookingRepository.deleteById(bookingId);
                response.put("status", "success");
                response.put("message", "Booking deleted successfully");
            } else {
                response.put("status", "error");
                response.put("message", "Booking id not found, please provide a correct id to delete");
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error deleting booking: " + e.getMessage());
        }
        return response;
    }
    @Transactional
    public Map<String, Object> addBookingWithTicket(BookingDTO bookingDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            int eventId = bookingDTO.getEventId();
            int userId = bookingDTO.getUserId();
            int numberOfTickets = bookingDTO.getNumberOfTickets();

            // Call the repository method to add booking with tickets
            List<Object[]> result = bookingRepository.addBookingWithTicket(eventId, userId, numberOfTickets, null);

            // Check the result from the stored procedure call
            if (!result.isEmpty()) {
                Object[] procedureResult = result.get(0); // Assuming only one result row
                String status = (String) procedureResult[0];
                if ("success".equals(status)) {
                    int bookingId = (int) procedureResult[1]; // Extract booking ID from the result

                    response.put("status", "success");
                    response.put("message", "Booking created successfully");
                    response.put("bookingId", bookingId); // Include booking ID in the response
                } else {
                    // Handle the case where the stored procedure call was not successful
                    response.put("status", "error");
                    response.put("message", status); // Use the status message from the stored procedure
                }
            } else {
                response.put("status", "error");
                response.put("message", "No result from procedure call");
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur during the booking process
            response.put("status", "error");
            response.put("message", "Error adding booking with ticket: " + e.getMessage());
        }
        return response;
    }
    
    public List<BookingDetailsDTO> getBookingDetails() {
        return bookingRepository.getBookingDetails();
    }
}


//package com.bookingservice.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bookingservice.dto.BookingDetailsDTO;
//import com.bookingservice.entity.Booking;
//import com.bookingservice.repository.BookingRepository;
//
//import jakarta.transaction.Transactional;
//
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    public Booking getBookingById(int bookingId) {
//        return bookingRepository.findById(bookingId).orElse(null);
//    }
//
//    public Booking createBooking(Booking booking) {
//        return bookingRepository.save(booking);
//    }
//
//    public String updateBooking(int bookingId, Booking booking) {
//        if (bookingRepository.existsById(bookingId)) {
//            booking.setId(bookingId); // Ensure the booking ID is set
//            bookingRepository.save(booking);
//            return "Booking updated successfully";
//        } else {
//            return "Booking id not found, please provide a correct id to update";
//        }
//    }
//
//    public String deleteBooking(int bookingId) {
//        if (bookingRepository.existsById(bookingId)) {
//            bookingRepository.deleteById(bookingId);
//            return "Booking deleted successfully";
//        } else {
//            return "Booking id not found, please provide a correct id to delete";
//        }
//    }
//    @Transactional
//    public String addBookingWithTicket(int eventId, int userId, int numberOfTickets) {
//        List<String> result = bookingRepository.addBookingWithTicket(eventId, userId, numberOfTickets);
//        return result.isEmpty() ? null : result.get(0);
//    }
//    public List<BookingDetailsDTO> getBookingDetails() {
//        return bookingRepository.getBookingDetails();
//    }
//@Transactional
//public Map<String, Object> addBookingWithTicket(int eventId, int userId, int numberOfTickets) {
//  Map<String, Object> response = new HashMap<>();
//  try {
//      List<Object[]> result = bookingRepository.addBookingWithTicket(eventId, userId, numberOfTickets, null);
//      
//      // Check the result from the stored procedure call
//      String status = (String) result.get(0)[0]; // First element of the first array
//      if ("success".equals(status)) {
//          int bookingId = (int) result.get(0)[1]; // Second element of the first array
//
//          response.put("status", "success");
//          response.put("message", "Booking created successfully");
//          response.put("bookingId", bookingId); // Include booking ID in the response
//      } else {
//          // Handle the case where the stored procedure call was not successful
//          response.put("status", "error");
//          response.put("message", status); // Use the status message from the stored procedure
//      }
//  } catch (Exception e) {
//      // Handle any exceptions that might occur during the stored procedure call
//      response.put("status", "error");
//      response.put("message", "Error adding booking with ticket: " + e.getMessage());
//  }
//  return response;
//}


	//@Transactional
	//public Map<String, Object> addBookingWithTicket(int eventId, int userId, int numberOfTickets) {
	//  Map<String, Object> response = new HashMap<>();
	//  try {
	//      List<String> result = bookingRepository.addBookingWithTicket(eventId, userId, numberOfTickets);
	//      if (result.isEmpty()) {
	//          response.put("status", "error");
	//          response.put("message", "Booking with ticket creation failed");
	//      } else {
	//          response.put("status", "success");
	//          response.put("message", result.get(0));
	//      }
	//  } catch (Exception e) {
	//      response.put("status", "error");
	//      response.put("message", "Error adding booking with ticket: " + e.getMessage());
	//  }
	//  return response;
	//}
	//
//}




