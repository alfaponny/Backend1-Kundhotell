package com.example.backenend1kundhotell.dtos;

import com.example.backenend1kundhotell.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MiniCustomerDto {
    long customerId;
    String firstName;
    String surname;


}
