package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;

	@RequestMapping("/all")
	public String getAllCustomers(Model model) {
		List<CustomerDto> customers = customerService.getAllCustomers();
		model.addAttribute("allCustomers", customers);
		model.addAttribute("title", "Customers");
		model.addAttribute("name", "Customer details");
		return "customers";
	}

	@RequestMapping("/add")
	public String addCustomer(@RequestParam String firstName, @RequestParam String surname,
							  @RequestParam String email, @RequestParam String phone,
							  Model model) {
		customerService.addCustomer(firstName, surname, email, phone);
		return "redirect:/customers/all";
	}


	//se kunder, lägga till kunder, ta bort kunder
}
