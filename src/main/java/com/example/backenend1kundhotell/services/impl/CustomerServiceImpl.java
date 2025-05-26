package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Override
    public void deleteById(long id){
        customerRepo.deleteById(id);
    }

    @Override
    public Customer findById(long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void updateById (long id, String firstName, String surname, String email, String phone){
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Kund hittades inte"));

        customer.setFirstName(firstName);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setPhone(phone);

        customerRepo.save(customer);
    }
}
