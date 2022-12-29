package com.infy.api.dto;

public class CabBookingDTO {
	
	private int bookingId ; 
	private long mobileNo ;
	private String from ;
	private String destination ;
	private int price ;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public CabBookingDTO() {
	}
	public int getPrice() {
		return price;
	}
	public CabBookingDTO(int bookingId, long mobileNo, String from, String destination, int price) {
		this.bookingId = bookingId;
		this.mobileNo = mobileNo;
		this.from = from;
		this.destination = destination;
		this.price = price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
