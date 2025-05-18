package com.example.backenend1kundhotell.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Booking {

	@Id
	@GeneratedValue
	private long id;
	private int nights;
	private int date; //ska det vara int?

	public Booking(int nights, int date) {
		this.nights = nights;
		this.date = date;

	}

	@ManyToOne
	@JoinColumn
	private Customer customer;

	@ManyToOne
	@JoinColumn
	private Room room;

	public Booking(int nights, int date, Customer customer, Room room) {
		this.nights = nights;
		this.date = date;
		this.customer = customer;
		this.room = room;

	}
}
