package com.test.booking.resource;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.test.booking.model.Booking;

@Path("/booking")
public class BookingResource {

	private List<Booking> bookings = new CopyOnWriteArrayList<Booking>();

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String bookRestaurant(Booking booking) {
		// assuming time slot is given by user for the same date, in String 24H Format
		booking.setBookingDate(new Date());
		validateSlot(booking.getTimeSlot());
		bookings.add(booking);
		return "success";
	}

	private void validateSlot(String timeSlot) {
		// slot should be only for 2h or less
		String[] timeSlots = timeSlot.split("\\-");
		if (timeSlots.length < 1 || timeSlots.length > 1) {
			if (Integer.valueOf(timeSlots[1]) > 24 || Integer.valueOf(timeSlots[0]) > 24) {
				throw new RuntimeException("Invalid Slot!");
			}
			int difference = Integer.valueOf(timeSlots[1]) - Integer.valueOf(timeSlots[0]);
			if (difference > 2 || difference < 0) {
				throw new RuntimeException("Invalid Slot!");
			}
		} else {
			throw new RuntimeException("Invalid Slot!");
		}
	}

	@GET
	@Path("/{bookingDate}")
	@Produces("application/json")
	public List<Booking> retrieveAllBooking(@PathParam("bookingDate") String bookingDate) {

		return bookings
				.stream()
				.filter(bkDate -> bkDate.getBookingDate().equals(bookingDate))
				.collect(Collectors.toList());
	}

}
