package com.example.backenend1kundhotell.services.impl;

import com.example.backenend1kundhotell.dtos.*;
import com.example.backenend1kundhotell.models.Booking;
import com.example.backenend1kundhotell.models.Customer;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.repos.BookingRepo;
import com.example.backenend1kundhotell.repos.CustomerRepo;
import com.example.backenend1kundhotell.repos.RoomRepo;
import com.example.backenend1kundhotell.services.BookingService;
import com.example.backenend1kundhotell.services.CustomerService;
import com.example.backenend1kundhotell.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final RoomRepo roomRepo;

    @Override
    public BookingDto bookingToBookingDto(Booking b) {
        return BookingDto.builder()
                .id(b.getId())
                .startDate(b.getStartDate())
                .endDate(b.getEndDate())
                .extraBed(b.getExtraBed())
                .miniCustomer(new MiniCustomerDto(b.getCustomer().getCustomerId(), b.getCustomer().getFirstName(), b.getCustomer().getSurname()))
                .miniRoom(roomService.roomToMiniRoomDto(b.getRoom()))
                .build();
    }

    @Override
    public MiniBookingDto bookingToMiniBookingDto(Booking b) {
        return MiniBookingDto.builder().id(b.getId()).build();
    }

    @Override
    public Booking bookingDtoToBooking(BookingDto dto, Customer customer, Room room) {
        return Booking.builder().id(dto.getId()).startDate(dto.getStartDate()).endDate(dto.getEndDate())
                .extraBed(dto.getExtraBed()).customer(customer).room(room).build();
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepo.findAll().stream()
                .map(this::bookingToBookingDto)
                .collect(Collectors.toList());
    }

/*
    @Override
    public void addBooking(BookingDto bookingDto) {
        Customer customer = customerRepo.findById(bookingDto.getMiniCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Kund hittades inte"));
        Room room = roomRepo.findById(bookingDto.getMiniRoom().getRoomId())
                .orElseThrow(() -> new RuntimeException("Rum hittades inte"));
        Booking booking = bookingDtoToBooking(bookingDto, customer, room);
        bookingRepo.save(booking);
    }

 */

    @Override
    public String addBooking(LocalDate startDate, LocalDate endDate, int extraBed, long customerId, long roomId) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("The customer was not found"));
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new RuntimeException("The room was not found"));

        if(!isRoomAvailable(roomId, startDate, endDate)){
            throw new IllegalArgumentException("The room is already booked during this period");
        }


       if(extraBed > room.getMaxExtraBed()){
           return "ERROR: Choose less extra beds";
       }
       // Kontrollera att rummet är ledigt med hjälp av hjälpmetoden (se längst ner)
        if (!isRoomAvailable(room, startDate, endDate)) {
            return "ERROR: The room is booked, choose another one";
            //throw new RuntimeException("Rummet är redan bokat under denna period.");
        }
        /*Booking booking = bookingDtoToBooking(bookingDto, customer, room);
        */
        Booking booking = new Booking(startDate, endDate, customer, room, extraBed);
        bookingRepo.save(booking);
        return "Booking is saved";
    }

    @Override
    public void deleteById(long id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public BookingDto findById(long id) {
        Booking b = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bokning hittades inte"));
        return bookingToBookingDto(b);
    }

    @Override
    public BookingDto getBookingById(long id) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bokning hittades inte"));
        return bookingToBookingDto(booking);
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {
        Booking booking = bookingRepo.findById(bookingDto.getId())
                .orElseThrow(() -> new RuntimeException("Bokning hittades inte"));
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());
        booking.setExtraBed(bookingDto.getExtraBed());
        booking.setCustomer(customerService.miniCustomerDtoToCustomer(bookingDto.getMiniCustomer()));
        booking.setRoom(roomService.miniRoomDtoToRoom(bookingDto.getMiniRoom()));
        bookingRepo.save(booking);
    }




    // Hjälpmetod för att kolla om ett rum är ledigt under ett intervall

    public boolean isRoomAvailable(long roomId, LocalDate startDate, LocalDate endDate) {
        Room room = roomRepo.findById(roomId).orElseThrow(() -> new RuntimeException("The room was not found"));

    List<Booking> bookings = bookingRepo.findByRoom(room);

        for (Booking b : bookings) {
            // Om bokningen matchar med önskat intervall, är rummet upptaget
            if (!(endDate.isBefore(b.getStartDate()) || startDate.isAfter(b.getEndDate()))) {
                return false;
            }
        }
        return true;
    }


}








/*
    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;
    private final RoomRepo roomRepo;


    @Override
    public BookingDto bookingToBookingDto(Booking b) {
        return BookingDto.builder().bookingId(b.getBookingId()).startDate(b.getStartDate())
                .endDate(b.getEndDate()).extraBed(b.getExtraBed()).build();
    }


    @Override
    public MiniBookingDto bookingToMiniBookingDto(Booking b) {
        return MiniBookingDto.builder().bookingId(b.getBookingId()).build();
    }

    @Override
    Booking bookingDtoToBooking (BookingDto dto, Customer customer, Room room) {
        Booking booking = new Booking();
        booking.setBookingId(dto.getBookingId());
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setExtraBed(dto.getExtraBed());
        booking.setCustomer(customer);
        booking.setRoom(room);
        return booking;
    }

    @Override
    public List<BookingDto> getAllBookings() {
           return bookingRepo.findAll().stream().map(b-> bookingToBookingDto(b)).toList();

    }

    @Override
    public void addBooking(BookingDto bookingDto) {
        Booking booking = bookingDtoToBooking(bookingDto);
        bookingRepo.save(booking);
    }


    @Override
    public void deleteById(long id) {
            bookingRepo.deleteById(id);

    }

    @Override
    public Booking findById(long id) {
        return bookingRepo.findById(id).get();



    @Override
    public BookingDto getBookingById(long id) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bokning hittades inte"));
        return bookingToBookingDto(booking);
    }



    @Override
    public void updateBooking(BookingDto bookingDto) {
            Booking booking = bookingRepo.findById(bookingDto.getBookingId()).get();
            booking.setStartDate(bookingDto.getStartDate());
            bookingRepo.save(booking);

    }

 */


