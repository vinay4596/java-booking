package com.test.booking;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.test.booking.resource.BookingResource;

import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;

public class StartupMain {

	public static void main(String[] args) {

		BookingResource bookingResource = new BookingResource();
        MuServerBuilder.muServer().withHttpPort(8080)
            .addHandler(
                RestHandlerBuilder.restHandler(bookingResource)
                    .addCustomWriter(new JacksonJaxbJsonProvider())
                    .addCustomReader(new JacksonJaxbJsonProvider())
            )
            .start();
        
        System.out.println("MuServer Started !!");
	}
}
