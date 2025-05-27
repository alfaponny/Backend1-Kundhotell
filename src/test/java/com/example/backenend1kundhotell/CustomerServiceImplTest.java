package com.example.backenend1kundhotell;


import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.dtos.MiniCustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.CustomerService;
import com.example.backenend1kundhotell.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CustomerServiceImplTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private BookingRepo bookingRepo;

    private CustomerService service = new CustomerServiceImpl(customerRepo);

    CustomerDto customerDto = new CustomerDto("JohnDto", "DoeDto", "johan@dto.com", "074600000");

    String customerName = "Peter";

    Customer customer = new Customer("John", "Doe", "johan@doe.com", "07457433");

    @Test
    void customerToCustomerDto(){
        CustomerDto actual = service.customerToCustomerDto(customer);
        assertEquals(actual.getFirstName(), customer.getFirstName());
        assertEquals(actual.getSurname(), customer.getSurname());

    }

    @Test
    void customerToMiniCustomerDto(){
        MiniCustomerDto actual = service.customerToMiniCustomerDto(customer);
        assertEquals(actual.getFirstName(), customer.getFirstName());

    }
    @Test
    void customerDtoToCustomer(){
        Customer actual = service.customerDtoToCustomer(customerDto);
        assertEquals(actual.getEmail(), customerDto.getEmail());
    }


}