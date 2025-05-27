package com.example.backenend1kundhotell.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

	@Id
	@GeneratedValue
	private long id;

	private LocalDate startDate;
	private LocalDate endDate;
	int extraBed;

	public Booking(LocalDate startDate, LocalDate endDate, int extraBed) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.extraBed = extraBed;
	}

	@ManyToOne
	@JoinColumn
	private Customer customer;

	@ManyToOne
	@JoinColumn
	private Room room;

	public Booking(LocalDate startDate, LocalDate endDate, Customer customer, Room room, int extraBed) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.room = room;
		this.extraBed = extraBed;
	}
}
