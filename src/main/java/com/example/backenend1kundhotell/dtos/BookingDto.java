package com.example.backenend1kundhotell.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "End date cannot be left empty")
    @FutureOrPresent(message= "Start date can only start from today")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be left empty")
    @Future(message = "End date can only be after start date")
    private LocalDate endDate;

    private int extraBed;

    @NotNull(message = "The customer need to be chosen")
    private MiniCustomerDto miniCustomer;

    private MiniRoomDto miniRoom;

    public BookingDto(LocalDate startDate, LocalDate endDate, int extraBed) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraBed = extraBed;
    }


}
