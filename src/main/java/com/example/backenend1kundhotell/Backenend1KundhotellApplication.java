package com.example.backenend1kundhotell;

import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.models.RoomType;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.repos.RoomRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Backenend1KundhotellApplication {

	public static void main(String[] args) {
		SpringApplication.run(Backenend1KundhotellApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookingRepo bookingRepo, CustomerRepo customerRepo,
								  RoomRepo roomRepo) {
		return args -> {
			Room room1 = new Room(0, RoomType.SINGLE);
			Room room2 = new Room(1, RoomType.DOUBLE);
			Room room3 = new Room(2, RoomType.DOUBLE);
			Room room4 = new Room(2, RoomType.DOUBLE);
			Room room5 = new Room(1, RoomType.DOUBLE);
			Room room6 = new Room(0, RoomType.SINGLE);
			Room room7 = new Room(0, RoomType.SINGLE);

			roomRepo.save(room1);
			roomRepo.save(room2);
			roomRepo.save(room3);
			roomRepo.save(room4);
			roomRepo.save(room5);
			roomRepo.save(room6);
			roomRepo.save(room7);

			Customer customer1 = new Customer("Helena", "Ericsson", "h.ericsson@mail.com", "073123456");
			Customer customer2 = new Customer("Karin", "Karlsson", "grymmakarin@hotmail.com", "0747256478");
			Customer customer3 = new Customer("Vincent", "Öberg", "vincet123@mail.com", "0748732872");
			Customer customer4 = new Customer("Fanny", "Lund", "f.lund@mail.com", "0748732444");

			customerRepo.save(customer1);
			customerRepo.save(customer2);
			customerRepo.save(customer3);
			customerRepo.save(customer4);
		};
		}
}
