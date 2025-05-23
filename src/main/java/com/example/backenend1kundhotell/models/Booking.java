package com.example.backenend1kundhotell.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor

public class Booking {

	@Id
	@GeneratedValue
	private long bookingId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int extraBeds;


	@ManyToOne
	@JoinColumn
	private Customer customer;

	@ManyToOne
	@JoinColumn
	private Room room;


    public Booking(LocalDate startDate, LocalDate endDate, int extraBeds, Customer customer, Room room) {
			this.startDate = startDate;
			this.endDate = endDate;
			this.extraBeds = extraBeds;
			this.customer = customer;
			this.room = room;

	}
}
