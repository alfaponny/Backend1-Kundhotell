package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;

public class CustomerController {
	private final CustomerRepo customerRepo;
	private final BookingRepo bookingRepo;

	CustomerController(CustomerRepo customerRepo, BookingRepo bookingRepo) {
		this.customerRepo = customerRepo;
		this.bookingRepo = bookingRepo;
	}

	//se kunder, lägga till kunder, ta bort kunder
}
