package com.example.backenend1kundhotell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private long customerId;

	@NotBlank(message = "Firstname cannot be empty")
	@Size(min = 2, max = 50)
	private String firstName;

	@NotBlank(message = "Surname cannot be empty")
	@Size(min = 2, max = 50)
	private String surname;

	@Email(message = "Email must be valid")
	@NotBlank(message = "E-mail annot be blank")
	private String email;

	@NotBlank (message = "Phone number needed")
	@Pattern(regexp = "\\d{7,15}", message = "Phone number must be between 7 and 15 digits")
	private String phone;

	public Customer(String firstName, String surname, String email, String phone) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	@OneToMany(mappedBy = "customer")//bi-directional mapping. //ändrat från bookings to customers
	private List<Booking> bookings;
}
