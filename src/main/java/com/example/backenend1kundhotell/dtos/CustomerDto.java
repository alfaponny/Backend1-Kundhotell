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

    long customerId;
    String firstName;
    String surname;
    String email;
    String phone;

}
