package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.MiniRoomDto;
import com.example.backenend1kundhotell.dtos.RoomDto;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    @Override
    public RoomDto roomToRoomDto(Room r) {
        return RoomDto.builder()
                .roomId(r.getRoomId())
                .maxExtraBed(r.getMaxExtraBed())
                .roomType(r.getRoomType())
                .build();
    }

    @Override
    public MiniRoomDto roomToMiniRoomDto(Room r) {
        return MiniRoomDto.builder()
                .roomId(r.getRoomId()).build();
    }
}