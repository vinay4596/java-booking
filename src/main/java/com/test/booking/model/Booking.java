package com.test.booking.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {

	private String customerName;

	private Integer tableSize;

	private Date bookingDate;

	private String timeSlot;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getTableSize() {
		return tableSize;
	}

	public void setTableSize(Integer tableSize) {
		this.tableSize = tableSize;
	}

	public String getBookingDate() {
		return bookingDate(bookingDate);
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	private String bookingDate(Date bookingDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(bookingDate);
		return date;
	}
}
