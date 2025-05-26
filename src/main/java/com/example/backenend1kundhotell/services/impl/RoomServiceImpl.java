package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.MiniRoomDto;
import com.example.backenend1kundhotell.dtos.RoomDto;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.models.RoomType;
import com.example.backenend1kundhotell.repos.RoomRepo;
import com.example.backenend1kundhotell.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepo roomRepo;

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

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> repoRooms = roomRepo.findAll();
        List<RoomDto> roomDtos = new ArrayList<>();
        for (Room room : repoRooms) {
            roomDtos.add(roomToRoomDto(room));
        }
        return roomDtos;
    }


    @Override
    public void addRoom(int maxExtraBed, String roomTypeString) {
        RoomType roomType;
        try {
            roomType = RoomType.valueOf(roomTypeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Ogiltig rumstyp: " + roomTypeString);
        }
        Room room = new Room(maxExtraBed, roomType);
        roomRepo.save(room);
    }
    @Override
    public void deleteRoomById(long id){
        roomRepo.deleteById(id);
    }

}

