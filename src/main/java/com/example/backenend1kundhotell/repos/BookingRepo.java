package com.example.backenend1kundhotell.repos;

import com.example.backenend1kundhotell.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
