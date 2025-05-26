package com.example.backenend1kundhotell.controllers;

import com.example.backenend1kundhotell.dtos.RoomDto;
import com.example.backenend1kundhotell.models.Room;
import com.example.backenend1kundhotell.repos.RoomRepo;
import com.example.backenend1kundhotell.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

        private final RoomService roomService;
        private final RoomRepo roomRepo;

        @RequestMapping("/all")
        public String getAllRooms(Model model) {
            List<RoomDto> customers = roomService.getAllRooms();
            model.addAttribute("allRooms", customers);
            model.addAttribute("title", "Rooms");
            model.addAttribute("name", "Room details");
            return "rooms";
        }

        @RequestMapping("/add")
        public String addRoom(@RequestParam int maxExtraBed, @RequestParam String roomType,
                                  Model model) {

            //roomType skickas som en sträng, för att omvandlas till enum i roomservice
            roomService.addRoom(maxExtraBed, roomType);
            return "redirect:/rooms/all";
        }

        @RequestMapping("/deleteById/{id}")
        public String deleteRoomByID(@PathVariable long id) {
            roomService.deleteRoomById(id);
            return "redirect:/rooms/all";
        }

}
