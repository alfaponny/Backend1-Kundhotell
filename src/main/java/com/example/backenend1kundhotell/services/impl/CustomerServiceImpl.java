package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniBookingDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.BookingService;
import com.example.backenend1kundhotell.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    @Override
    public Customer customerDtoToCustomer(CustomerDto c){
        return Customer.builder().customerId(c.getCustomerId())
                .email(c.getEmail())
                .phone(c.getPhone())
                .firstName(c.getFirstName())
                .surname(c.getSurname()).build();
    }

    @Override
    public Customer miniCustomerDtoToCustomer(MiniCustomerDto c){
        return Customer.builder().customerId(c.getCustomerId())
                .firstName(c.getFirstName())
                .surname(c.getSurname()).build();
    }


    @Override
    public CustomerDto customerToCustomerDto(Customer c){
        List<MiniBookingDto> miniBookings = new ArrayList<>();
        if (c.getBookings() != null) {
            miniBookings = c.getBookings().stream()
                    .map(b -> new MiniBookingDto(b.getId()))
                    .toList();
        }
        return CustomerDto.builder().customerId(c.getCustomerId())
                .email(c.getEmail())
                .phone(c.getPhone())
                .firstName(c.getFirstName())
                .surname(c.getSurname())
                .miniBookingDto(miniBookings)
                .build();
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
    public void addCustomer(CustomerDto customerDto) {
        Customer customer = customerDtoToCustomer(customerDto);
        customerRepo.save(customer);
    }
    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Customer customer = customerDtoToCustomer(customerDto);
        customerRepo.save(customer);
    }
    @Override
    public String deleteById(long id){
        Customer customer = customerRepo.findById(id).get();
        if(customer.getBookings().isEmpty()){
            customerRepo.deleteById(id);
            return "Customer deleted";
        }
        return "Customer has active bookings";
    }

    @Override
    public CustomerDto findById(long id) {
        Customer customer = customerRepo.findById(id).orElse(null);
        return customerToCustomerDto(customer);
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
