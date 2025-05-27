package com.example.backenend1kundhotell.dtos;

import com.example.backenend1kundhotell.models.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class RoomDto {

    private long roomId;
    private int maxExtraBed;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private List<MiniBookingDto> miniBookingDto;

}
