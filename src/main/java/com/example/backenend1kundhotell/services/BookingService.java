package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.models.Booking;


public interface BookingService {

    public BookingDto bookingToBookingDto (Booking b);

}
