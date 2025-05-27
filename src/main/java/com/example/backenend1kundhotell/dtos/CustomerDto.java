package com.example.backenend1kundhotell.dtos;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerDto {

    private long customerId;

    @NotBlank(message = "Firstname cannot be empty")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Surname cannot be empty")
    @Size(min = 2, max = 50)
    private String surname;

    @Email(message = "Email must be valid")
    @NotBlank(message = "E-mail cannot be blank")
    private String email;

    @NotBlank (message = "Phone number needed")
    @Pattern(regexp = "\\d{7,15}", message = "Phone number must be between 7 and 15 digits")
    private String phone;


    private List<MiniBookingDto> miniBookingDto;

    CustomerDto(String firstName, String surname, String email, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

}
