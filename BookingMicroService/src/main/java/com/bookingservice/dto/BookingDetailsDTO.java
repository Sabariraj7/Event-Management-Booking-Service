package com.bookingservice.dto;

import java.sql.Timestamp;

public class BookingDetailsDTO {
	private int bookingId;
    private String userName;
    private String phone;
    private String eventName;
    private String hallName;
    private String location;
    private Timestamp eventDate;
    private int numberOfTickets;
    private double totalPrice;
    private double offeredPrice;

    // Add getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
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

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }
    public BookingDetailsDTO() {
    	
    }
    
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingDetailsDTO(int bookingId, String userName, String phone, String eventName, String hallName,
			String location, Timestamp eventDate, int numberOfTickets, double totalPrice, double offeredPrice) {
		super();
		this.bookingId = bookingId;
		this.userName = userName;
		this.phone = phone;
		this.eventName = eventName;
		this.hallName = hallName;
		this.location = location;
		this.eventDate = eventDate;
		this.numberOfTickets = numberOfTickets;
		this.totalPrice = totalPrice;
		this.offeredPrice = offeredPrice;
	}

	
    
}
