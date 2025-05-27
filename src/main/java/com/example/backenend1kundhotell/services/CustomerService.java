package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Customer;

import java.util.List;

public interface CustomerService {

    public CustomerDto customerToCustomerDto (Customer c);

    public MiniCustomerDto customerToMiniCustomerDto (Customer c);

    public Customer customerDtoToCustomer(CustomerDto c);

    public List<CustomerDto> getAllCustomers();

    public String deleteById(long id);

   public CustomerDto findById(long id);

    public void updateById(long id, String firstName, String surname, String email, String phone);

    public  void addCustomer(CustomerDto customerDto);//tar emot Customer-objekt direkt

    void updateCustomer(CustomerDto customerDto);
}
