package com.example.backenend1kundhotell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue
	private long id;

	public Room(long id) {
		this.id = id;
	}
}
