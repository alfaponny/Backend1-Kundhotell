package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.*;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.models.Room;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;


public interface BookingService {

    public BookingDto bookingToBookingDto (Booking b);

           Booking bookingDtoToBooking (BookingDto dto, Customer customer, Room room);

    public MiniBookingDto bookingToMiniBookingDto (Booking b);


    public List<BookingDto> getAllBookings();

    public  String addBooking(LocalDate startDate, LocalDate endDate, int extraBed, long customerId, long roomId);

    public void deleteById(long id);

    public BookingDto findById(long id);

    public void updateBooking( BookingDto bookingDto);

    public BookingDto getBookingById(long id);

    public List<MiniRoomDto> findAvailableRooms(LocalDate startDate, LocalDate endDate, int guests);
}
