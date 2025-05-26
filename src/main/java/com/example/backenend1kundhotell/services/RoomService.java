package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.MiniRoomDto;
import com.example.backenend1kundhotell.dtos.RoomDto;
import com.example.backenend1kundhotell.models.Room;

import java.util.List;

public interface RoomService {

    public RoomDto roomToRoomDto (Room r);

    public MiniRoomDto roomToMiniRoomDto (Room r);


    public List<RoomDto> getAllRooms();

    void addRoom(int maxExtraBed, String roomType);

    void deleteRoomById(long id);
}
