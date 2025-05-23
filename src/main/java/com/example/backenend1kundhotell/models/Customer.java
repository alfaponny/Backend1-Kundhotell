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

	public Customer(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	@OneToMany(mappedBy = "customers")//bi-directional mapping. //ändrat från bookings to customers
	private List<Booking> bookings;
}
