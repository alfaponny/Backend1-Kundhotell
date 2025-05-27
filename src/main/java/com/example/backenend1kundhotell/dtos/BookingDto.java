package com.example.backenend1kundhotell.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookingDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int extraBed;
    private MiniCustomerDto miniCustomer;
    private MiniRoomDto miniRoom;

    public BookingDto(LocalDate startDate, LocalDate endDate, int extraBed) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraBed = extraBed;
    }


}
