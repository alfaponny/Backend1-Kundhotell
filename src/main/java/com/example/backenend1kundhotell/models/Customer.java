package com.example.backenend1kundhotell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private String firstName;
	private String surname;
	private String email;
	private String phone;

	public Customer(String firstName, String surname, String email, String phone) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	@OneToMany(mappedBy = "customers")//bi-directional mapping. //ändrat från bookings to customers
	private List<Booking> bookings;
}
