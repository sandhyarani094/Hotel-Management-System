package com.bipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipro.model.CheckInDetails;
import com.bipro.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepo;
	
	public List<CheckInDetails> getCheckedInDetailsByRoomNo(int roomNo) {
		return bookingRepo.getCheckedInDetailsByRoomNo(roomNo);
	}

	public List<CheckInDetails> getCheckedInDetails() {
		return bookingRepo.getCheckedInDetails();
	}

}
