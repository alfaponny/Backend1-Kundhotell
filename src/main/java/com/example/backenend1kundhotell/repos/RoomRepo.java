package com.example.backenend1kundhotell.repos;

import com.example.backenend1kundhotell.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {
}
