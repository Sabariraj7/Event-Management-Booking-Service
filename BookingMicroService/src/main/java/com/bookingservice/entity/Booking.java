package com.bookingservice.entity;

import java.sql.Timestamp;

import com.eventmanagement.Entity.Event;
import com.eventmanagement.Entity.User;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "number_of_tickets")
    private int numberOfTickets;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "booking_date")
    private Timestamp bookingDate;

    @Column(name = "offered_price")
    private double offeredPrice;

    public Booking() {
    }

    public Booking(Event event, User user, int numberOfTickets, double totalPrice, Timestamp bookingDate, double offeredPrice) {
        this.event = event;
        this.user = user;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.offeredPrice = offeredPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", event=" + event +
                ", user=" + user +
                ", numberOfTickets=" + numberOfTickets +
                ", totalPrice=" + totalPrice +
                ", bookingDate=" + bookingDate +
                ", offerPrice=" + offeredPrice +
                '}';
    }
}
