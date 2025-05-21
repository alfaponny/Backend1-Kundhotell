package com.example.backenend1kundhotell.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue
	private long roomId;
	int maxExtraBed;

	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	public Room(int maxExtraBed, RoomType roomtype) {

		this.maxExtraBed = maxExtraBed;
		this.roomType = roomtype;
	}
}
