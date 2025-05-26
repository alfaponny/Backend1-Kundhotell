package com.example.backenend1kundhotell.repos;

import com.example.backenend1kundhotell.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    /*void updateById(long id, String firstName, String surname, String email, String phone);*/
}
