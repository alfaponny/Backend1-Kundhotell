package com.example.backenend1kundhotell.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerDto {


    String getEmail;
    long customerId;
    String firstName;
    String surname;
    String email;
    String phone;
    MiniBookingDto miniBookingDto;

    CustomerDto(String firstName, String surname, String email, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

}
