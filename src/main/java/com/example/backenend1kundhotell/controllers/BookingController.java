package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.repos.RoomRepo;
import com.example.backenend1kundhotell.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookingController {

	private final BookingService bookingService;



}
