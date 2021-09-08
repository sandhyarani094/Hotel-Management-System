package com.bipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipro.model.Response;
import com.bipro.model.Rooms;
import com.bipro.repository.RoomRepository;

@RestController
public class RoomController {
	@Autowired
	RoomRepository roomRepo;

	@PostMapping("/getRoomDetails")
	public List<Rooms> getRoomDetails(@RequestBody RoomTypeDetails roomType) {
		return roomRepo.getRoomDetails(roomType.roomtype, roomType.roomsize);

	}

	@PostMapping("/addRoom")
	public Response addRoom(@RequestBody Rooms room) {
		Response resp = new Response();
		roomRepo.save(room);
		resp.setResponseValue("Room added successfully");
		return resp;
	}

	@PostMapping("/getNewRoomNumber")
	public int getNewRoomNumber(@RequestBody int floor) {
		int roomNumber = roomRepo.getNewRoomNumber(floor * 100, (floor + 1) * 100);
		return roomNumber;
	}

	@GetMapping("/getAllRoomDetails")
	public List<Rooms> getAllRoomDetails() {
		return roomRepo.getAllRoomDetails();

	}

}

class RoomTypeDetails {
	public String roomtype;
	public double roomsize;
}
