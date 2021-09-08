package com.bipro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ROOMDETAILS",uniqueConstraints=@UniqueConstraint(columnNames={"roomnumber"}))
public class Rooms {
	@Id
	private int roomnumber;
	private boolean status;
	private String roomtype;
	private double roomsize;
	private double price;
	public int getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public double getRoomsize() {
		return roomsize;
	}
	public void setRoomsize(double roomsize) {
		this.roomsize = roomsize;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Rooms [roomnumber=" + roomnumber + ", status=" + status + ", roomtype=" + roomtype + ", roomsize="
				+ roomsize + ", price=" + price + "]";
	}
	
	public Rooms(int roomnumber, boolean status, String roomtype, double roomsize, double price) {
		super();
		this.roomnumber = roomnumber;
		this.status = status;
		this.roomtype = roomtype;
		this.roomsize = roomsize;
		this.price = price;
	}
	public Rooms() {
		super();
		
	}
	
	

}
