package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.repos.RoomRepo;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
	private final BookingRepo bookingRepo;
	private final CustomerRepo customerRepo;
	private final RoomRepo roomRepo;

	BookingController(BookingRepo bookingRepo, CustomerRepo customerRepo, RoomRepo roomRepo) {
		this.bookingRepo = bookingRepo;
		this.customerRepo = customerRepo;
		this.roomRepo = roomRepo;
	}
}
