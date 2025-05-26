package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.repos.RoomRepo;
import com.example.backenend1kundhotell.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;
    private final RoomRepo roomRepo;


    @Override
    public BookingDto bookingToBookingDto(Booking b) {
        return BookingDto.builder().bookingId(b.getBookingId()).startDate(b.getStartDate())
                .endDate(b.getEndDate()).extraBed(b.getExtraBed()).build();
    }


    @Override
    public MiniBookingDto bookingToMiniBookingDto(Booking b) {
        return MiniBookingDto.builder().bookingId(b.getBookingId()).build();
    }

    @Override
    Booking bookingDtoToBooking (BookingDto dto, Customer customer, Room room) {
        Booking booking = new Booking();
        booking.setBookingId(dto.getBookingId());
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setExtraBed(dto.getExtraBed());
        booking.setCustomer(customer);
        booking.setRoom(room);
        return booking;
    }

    @Override
    public List<BookingDto> getAllBookings() {
           return bookingRepo.findAll().stream().map(b-> bookingToBookingDto(b)).toList();

    }

    @Override
    public void addBooking(BookingDto bookingDto) {
        Booking booking = bookingDtoToBooking(bookingDto);
        bookingRepo.save(booking);
    }


    @Override
    public void deleteById(long id) {
            bookingRepo.deleteById(id);

    }

    @Override
    public Booking findById(long id) {
        return bookingRepo.findById(id).get();

    }

    @Override
    public void updateBooking(BookingDto bookingDto) {
            Booking booking = bookingRepo.findById(bookingDto.getBookingId()).get();
            booking.setStartDate(bookingDto.getStartDate());

    }


}
