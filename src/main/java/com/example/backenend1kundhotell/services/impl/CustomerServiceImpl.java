package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto customerToCustomerDto(Customer c){
        return CustomerDto.builder().customerId(c.getCustomerId())
                .email(c.getEmail())
                .phone(c.getPhone())
                .firstName(c.getFirstName())
                .surname(c.getSurname()).build();

    }
}
