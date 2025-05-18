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
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String booking;

	public Customer(String firstName, String lastName, String email, String phone, String booking) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.booking =booking;
	}
	@OneToMany(mappedBy = "booking")//bi-directional mapping.
	private List<Booking> bookings;
}
