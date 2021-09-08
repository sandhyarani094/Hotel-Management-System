package com.bipro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="USERDETAILS",uniqueConstraints=@UniqueConstraint(columnNames={"phno","mailid"}))
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mailid;
	private String password;
	private String phno;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", mailid=" + mailid + ", password=" + password + ", phno="
				+ phno + ", address=" + address + "]";
	}
	
	public UserModel(int id, String name, String mailid, String password, String phno, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mailid = mailid;
		this.password = password;
		this.phno = phno;
		this.address = address;
	}
	public UserModel() {
		super();
		
	}
	

}
