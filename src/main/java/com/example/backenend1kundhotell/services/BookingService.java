package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Customer;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface BookingService {

    public BookingDto bookingToBookingDto (Booking b);

    public MiniBookingDto bookingToMiniBookingDto (Booking b);







    public List<BookingDto> getAllBookings();

    public  void addBooking( BookingDto bookingDto);

    public void deleteById(long id);

    public Booking findById(long id);

    public void updateBooking( BookingDto bookingDto);


}
