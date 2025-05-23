package com.example.backenend1kundhotell.dtos;

import com.example.backenend1kundhotell.models.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class RoomDto {
    long roomId;
    int maxExtraBed;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;


}
