package com.bipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipro.model.CheckInDetails;
import com.bipro.model.Response;
import com.bipro.repository.BookingRepository;
import com.bipro.repository.RoomRepository;
import com.bipro.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingRepository bookingRepo;

	@Autowired
	RoomRepository roomRepo;

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/allocateRoom")
	public Response customerCheckIn(@RequestBody CheckInDetails details) {
		bookingRepo.save(details);
		roomRepo.makeRoomUnavailble(details.getRoomNumber());
		Response resp = new Response();
		resp.setResponseValue("You are successfully checked in");
		return resp;
	}

	@GetMapping("/getCheckedInDetails")
	public List<CheckInDetails> getCheckedInDetails() {
		return bookingService.getCheckedInDetails();
	}
	
	@PostMapping("/getCheckedInDetailsByRoomNo")
	public  List<CheckInDetails> getCheckedInDetailsByRoomNo(@RequestBody int roomNo) {
		return bookingService.getCheckedInDetailsByRoomNo(roomNo);
	}

	@PostMapping("/checkout")
	public Response customerCheckOut(@RequestBody Checkout chkout) {
		bookingRepo.customerCheckOut(chkout.bookingId);
		bookingRepo.updateRoomStatus(chkout.roomNumber);
		Response resp = new Response();
		resp.setResponseValue("You are checked out successfully");
		return resp;
	}

}

class Checkout {
	public int bookingId;
	public int roomNumber;
}