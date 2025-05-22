package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.models.Customer;


public interface CustomerService {

    public CustomerDto customerToCustomerDto (Customer c);

}
