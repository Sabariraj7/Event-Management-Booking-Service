package com.bookingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_tickets")
public class BookingTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;
    
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Booking event;

    public Booking getEvent() {
		return event;
	}

	public void setEvent(Booking event) {
		this.event = event;
	}

	@Column(name = "seat_number")
    private String seatNumber;


    public BookingTickets() {
    }

    public BookingTickets(Booking booking, String seatNumber) {
        this.booking = booking;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "BookingTicket{" +
                "id=" + id +
                ", booking=" + booking +
                ", event=" + event +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
