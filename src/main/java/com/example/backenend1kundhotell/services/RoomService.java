package com.example.backenend1kundhotell.services;

import com.example.backenend1kundhotell.dtos.MiniRoomDto;
import com.example.backenend1kundhotell.dtos.RoomDto;
import com.example.backenend1kundhotell.models.Room;

public interface RoomService {

    public RoomDto roomToRoomDto (Room r);

    public MiniRoomDto roomToMiniRoomDto (Room r);

}
