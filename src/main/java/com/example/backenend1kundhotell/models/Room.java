package com.example.backenend1kundhotell.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
	@Id
	@GeneratedValue
	private long roomId;

	//@Size(max=2, message="You chose too many extra beds")
	private int maxExtraBed;


	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	public Room(int maxExtraBed, RoomType roomtype) {
		this.maxExtraBed = maxExtraBed;
		this.roomType = roomtype;
	}
}
