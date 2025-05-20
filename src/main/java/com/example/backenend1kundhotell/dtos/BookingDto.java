package com.example.backenend1kundhotell.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookingDto {
    long id;
    int nights;
    LocalDate startDate;
    long customerId;

}
