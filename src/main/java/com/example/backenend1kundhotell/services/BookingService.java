package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
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

    public  String addBooking(BookingDto bookingDto);

    public void deleteById(long id);

    public BookingDto findById(long id);

    public void updateBooking( BookingDto bookingDto);

    public BookingDto getBookingById(long id);


    // Hjälpmetod för att kolla om ett rum är ledigt under ett intervall
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate);
}
