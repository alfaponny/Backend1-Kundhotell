package com.example.backenend1kundhotell.repos;

import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByRoom(Room room);
}