package com.bipro.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CHECKINDETAILS")
public class CheckInDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String mobileNo;
	private String nationality;
	private String gender;
	private String email;
	private String address;
	private Date checkInDate;
	private String idProof;
	private String bed;
	private String roomType;
	private int roomNumber;
	private double price;
	private Date checkoutdate;
	private boolean checkoutstatus;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public boolean isCheckoutstatus() {
		return checkoutstatus;
	}
	public void setCheckoutstatus(boolean checkoutstatus) {
		this.checkoutstatus = checkoutstatus;
	}
	public CheckInDetails(int customerId, String name, String mobileNo, String nationality, String gender, String email,
			String address, Date checkInDate, String idProof, String bed, String roomType, int roomNumber, double price,
			Date checkoutdate, boolean checkoutstatus) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.nationality = nationality;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.checkInDate = checkInDate;
		this.idProof = idProof;
		this.bed = bed;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.price = price;
		this.checkoutdate = checkoutdate;
		this.checkoutstatus = checkoutstatus;
	}
	@Override
	public String toString() {
		return "CheckInDetails [customerId=" + customerId + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", nationality=" + nationality + ", gender=" + gender + ", email=" + email + ", address=" + address
				+ ", checkInDate=" + checkInDate + ", idProof=" + idProof + ", bed=" + bed + ", roomType=" + roomType
				+ ", roomNumber=" + roomNumber + ", price=" + price + ", checkoutdate=" + checkoutdate
				+ ", checkoutstatus=" + checkoutstatus + "]";
	}
	public CheckInDetails() {
		super();
		
	}	
}
