package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private final BookingRepo bookingRepo;


        @Override
        public BookingDto bookingToBookingDto(Booking b) {
            return BookingDto.builder().bookingId(b.getBookingId()).startDate(b.getStartDate())
                    .endDate(b.getEndDate()).extraBed(b.getExtraBed()).build();
        }

    @Override
    public Booking bookingDtoToBooking(Booking b) {
        return BookingDto.builder().bookingId(b.getBookingId()).startDate(b.getStartDate())
                .endDate(b.getEndDate()).extraBed(b.getExtraBed()).build();
    }

    @Override
    public MiniBookingDto bookingToMiniBookingDto(Booking b) {
        return MiniBookingDto.builder().bookingId(b.getBookingId()).build();
    }

    @Override
    public List<BookingDto> getAllBookings() {
           return bookingRepo.findAll().stream().map(b-> bookingToBookingDto(b)).toList();

    }

    @Override
    public void addBooking(BookingDto bookingDto) {
            return bookingRepo.save()

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
