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
    long id;
    LocalDate startDate;
    LocalDate endDate;
    long customerId;
    int extraBed;


}
