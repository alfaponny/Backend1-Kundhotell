package com.example.backenend1kundhotell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	}
}
