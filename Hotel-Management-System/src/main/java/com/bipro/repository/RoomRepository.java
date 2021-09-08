package com.bipro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bipro.model.Rooms;

public interface RoomRepository extends JpaRepository<Rooms,Integer>{

	@Query(value="select * from roomdetails where roomtype=?1 and roomsize=?2 order by roomnumber",nativeQuery=true)
	public List<Rooms> getRoomDetails(String roomtype, double roomsize);

	@Modifying
	@Transactional
	@Query(value="update roomdetails set status=false where roomnumber=?",nativeQuery=true)
	public void makeRoomUnavailble(int roomNumber);

	@Query(value="select max(roomnumber)+1 from roomdetails where roomnumber > ?1 and roomnumber < ?2",nativeQuery=true)
	public int getNewRoomNumber(int i, int j);

	@Query(value="select * from roomdetails order by roomnumber",nativeQuery=true)
	public List<Rooms> getAllRoomDetails();

}
