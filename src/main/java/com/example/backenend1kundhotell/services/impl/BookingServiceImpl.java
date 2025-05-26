package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


        @Override
        public BookingDto bookingToBookingDto(Booking b) {
            return BookingDto.builder().bookingId(b.getBookingId()).startDate(b.getStartDate())
                    .endDate(b.getEndDate()).extraBed(b.getExtraBed()).build();
        }

    @Override
    public MiniBookingDto bookingToMiniBookingDto(Booking b) {
        return MiniBookingDto.builder().bookingId(b.getBookingId()).build();
    }





    }
