package com.example.backenend1kundhotell.controllers;


import com.example.backenend1kundhotell.dtos.BookingDto;
import com.example.backenend1kundhotell.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

	private final BookingService bookingService;

	@RequestMapping("/all")
	public String getAllBookings(Model model) {
		List<BookingDto> bookings = bookingService.getAllBookings();
		model.addAttribute("allBookings", bookings);
		model.addAttribute("title", "Bookings");
		model.addAttribute("name", "Booking details");
		return "bookings.html";
	}

	@RequestMapping("/addBooking/{customerId}")
	public String addNewBookings(@PathVariable long customerId, Model model) {
		model.addAttribute("customerId", customerId);
		return "addBooking.html";
	}

	@PostMapping ("/add")
	public String addBooking(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
							 @RequestParam int extraBed, @RequestParam long customerId,
							 @RequestParam long roomId, Model model, RedirectAttributes redirect){

		String answer = bookingService.addBooking(startDate, endDate, extraBed, customerId, roomId);
		if (answer.contains("ERROR")) {
			redirect.addFlashAttribute("message", answer);
			return "redirect:/bookings/add?customerId=" + customerId;
		}
		redirect.addFlashAttribute("message", answer);
		return "redirect:/bookings/all";
	}

	@GetMapping("/add")
	public String showAddBookingForm(@RequestParam long customerId, Model model) {
		model.addAttribute("customerId", customerId);
		return "addBooking.html";
	}

	@RequestMapping("/deleteById/{id}")
	public String deleteBookingByID(@PathVariable long id) {
		bookingService.deleteById(id);
		return "redirect:/bookings/all";
	}

	@RequestMapping("/updateById/{id}")
	public String updateBookingByID(@PathVariable long id, Model model) {
		BookingDto b = bookingService.findById(id);
		//Bokningen som hittas skickas vidare till uppdaterings formulär sidan
		model.addAttribute("booking", b);
		return "updateBooking.html";
	}

	@RequestMapping("/update")
	public String updateBooking(@RequestBody BookingDto bookingDto, Model model) {
		//Metoden updateById() anropas, där kunden kan hittas, och uppdateras
		bookingService.updateBooking(bookingDto);
		//Lägga till felmeddelande när kunden inte hittades, eller ändringar inte kunde genomföras
		return "redirect:/bookings/all";
	}

}