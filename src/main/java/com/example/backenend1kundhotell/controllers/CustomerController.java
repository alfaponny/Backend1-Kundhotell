package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.dtos.CustomerDto;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;
	private final CustomerRepo customerRepo;

	//Skapa en metod findById() eller findByEmail()?


	@RequestMapping("/all")
	public String getAllCustomers(Model model) {
		List<CustomerDto> customers = customerService.getAllCustomers();
		model.addAttribute("allCustomers", customers);
		model.addAttribute("title", "Customers");
		model.addAttribute("name", "Customer details");
		return "customers";
	}

	@RequestMapping("/addCustomer")
	public String addNewCustomer(Model model) {
		model.addAttribute("customer", new CustomerDto());
		return "addCustomer";
	}

	@RequestMapping("/add")
	public String addCustomer(@ModelAttribute @Valid CustomerDto customerDto, //BindingResult fångar valideringfel
							  BindingResult result, //ModelAttribute("customer") skpar ett nyt Customer-objekt
							  Model model) {
		//model.addAttribute("customer", new CustomerDto());
		if(result.hasErrors()) {
			model.addAttribute("allCustomers", customerService.getAllCustomers());
			model.addAttribute("title", "Customers");
			model.addAttribute("name", "Customer details");
			return "addCustomer";
		}
		//Customer customer = convertToEntity(customerDto);
		customerService.addCustomer(customerDto);
		return "redirect:/customers/all";
	}
	private Customer convertToEntity(CustomerDto customerDto) {
		return new Customer(customerDto.getFirstName(), customerDto.getSurname(),
				customerDto.getGetEmail(), customerDto.getPhone());
	}

	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto,
								 BindingResult result) {
		if(result.hasErrors()) {
			return "updateCustomer";
		}
		Customer customer = convertToEntity(customerDto);
		customerService.updateCustomer(customer);
		return "redirect:/customers/all";
	}

	@RequestMapping("/deleteById/{id}")
	public String deleteCustomerByID(@PathVariable long id) {
		//I den metoden behöver man kolla om kunden har aktiva bokningar
		customerService.deleteById(id);
		return "redirect:/customers/all";
	}

	@RequestMapping("/updateById/{id}")
	public String updateCustomerByID(@PathVariable long id, Model model) {
		Customer c = customerService.findById(id);
		//Kunden som hittas skickas vidare till uppdaterings formulär sidan
		model.addAttribute("customer", c);
		return "updateCustomer.html";
	}

	@RequestMapping("/updateByParams")
	public String updateCustomer(@RequestParam String firstName, @RequestParam String surname,
							  @RequestParam String email, @RequestParam String phone,
								 @RequestParam long id, Model model) {
		//Metoden updateById() anropas, där kunden kan hittas, och uppdateras
		customerService.updateById(id, firstName, surname, email, phone);
		//Lägga till felmeddelande när kunden inte hittades, eller ändringar inte kunde genomföras
		return "redirect:/customers/all";
	}

	//se kunder, lägga till kunder, ta bort kunder
}
