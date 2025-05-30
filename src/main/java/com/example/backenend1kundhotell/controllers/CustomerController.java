package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/addCustomer")
	public String addNewCustomer(Model model) {
		model.addAttribute("customer", new CustomerDto());
		return "addCustomer";
	}

	@PostMapping("/add")
	public String addCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, //BindingResult fångar valideringfel
							  BindingResult result, //ModelAttribute("customer") skapar ett nytt Customer-objekt
							  Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allCustomers", customerService.getAllCustomers());
			model.addAttribute("title", "Customers");
			model.addAttribute("name", "Customer details");
			return "addCustomer";
		}
		customerService.addCustomer(customerDto);
		return "redirect:/customers/all";
	}

	@RequestMapping("/deleteById/{id}")
	public String deleteCustomerByID(@PathVariable long id, RedirectAttributes redirect) {
		//I den metoden behöver man kolla om kunden har aktiva bokningar
		String answer = customerService.deleteById(id);
		if (answer.equals("Customer deleted")) {
			redirect.addFlashAttribute("successMessage", answer);
		} else {
			redirect.addFlashAttribute("errorMessage", answer);
		}
		return "redirect:/customers/all";
	}

	@RequestMapping("/updateById/{id}")
	public String updateCustomerById(@PathVariable long id, Model model) {
		CustomerDto c = customerService.findById(id);
		//Kunden som hittas skickas vidare till uppdaterings formulär sidan
		model.addAttribute("customerU", c);
		return "updateCustomer";
	}

	@PostMapping ("/update")
	public String updateCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto,
								 BindingResult result) {
		if(result.hasErrors()) {
			return "updateCustomer";
		}
		customerService.updateCustomer(customerDto);
		return "redirect:/customers/all";
	}

}
