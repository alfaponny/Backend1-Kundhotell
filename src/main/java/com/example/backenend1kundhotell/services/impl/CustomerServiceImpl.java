package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    @Override
    public CustomerDto customerToCustomerDto(Customer c){
        return CustomerDto.builder().customerId(c.getCustomerId())
                .email(c.getEmail())
                .phone(c.getPhone())
                .firstName(c.getFirstName())
                .surname(c.getSurname()).build();
    }

    @Override
    public MiniCustomerDto customerToMiniCustomerDto(Customer c){
        return MiniCustomerDto.builder().customerId(c.getCustomerId())
                .firstName(c.getFirstName())
                .surname(c.getSurname()).build();
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepo.findAll().stream().map(c -> customerToCustomerDto(c)).toList();
    }

    @Override
    public void addCustomer(String firstName, String surname, String email, String phone){
        customerRepo.save(new Customer(firstName, surname, email, phone));
    }
}
