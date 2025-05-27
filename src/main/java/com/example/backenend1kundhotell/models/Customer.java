package com.example.backenend1kundhotell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	@Id
	@GeneratedValue
	long customerId;
	String firstName;
	String surname;
	String email;
	String phone;

	public Customer(String firstName, String surname, String email, String phone) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	@OneToMany(mappedBy = "customer")//bi-directional mapping. //ändrat från bookings to customers
	private List<Booking> bookings;
}
