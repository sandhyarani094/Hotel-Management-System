package com.bipro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bipro.model.CheckInDetails;

public interface BookingRepository extends CrudRepository<CheckInDetails, Integer >{
	
    @Query(value="select * from checkindetails where checkoutstatus='false' and checkoutdate is null",nativeQuery=true)
	public List<CheckInDetails> getCheckedInDetails();

    @Modifying
	@Transactional
    @Query(value="update checkindetails set checkoutstatus='true', checkoutdate=now() where customer_id=?",nativeQuery=true)
	public void customerCheckOut(int bookingId);

    @Modifying
	@Transactional
    @Query(value="update roomdetails set status='true' where roomnumber=?",nativeQuery=true)
	public void updateRoomStatus(int roomNumber);

    @Query(value="select * from checkindetails where room_number=? and checkoutstatus='false' limit 1",nativeQuery=true)
	public List<CheckInDetails> getCheckedInDetailsByRoomNo(int roomNo);
	
}
