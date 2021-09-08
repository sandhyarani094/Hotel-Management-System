package com.bipro.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
	/*
	 * @TableGenerator(name = "EmployeeId_Gen", initialValue = 1000, allocationSize
	 * = 100)
	 */
	
	/*
	 * @GeneratedValue(strategy = GenerationType.TABLE, generator =
	 * "EmployeeId_Gen")
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int employeeId;
	@Column(name = "NAME")
	private String employeeName;
	@Column(name = "AGE")
	private int employeeAge;
	@Column(name = "SALARY")
	private double employeeSalary;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DOJ")
	private Date dateOfJoining;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "DOR")
	private Date dateOfRelive;
	@Column(name = "VACCINATIONSTATUS")
	private String vaccinationStatus;
	@Column(name = "EMPLOYMENTSTATUS")
	private boolean employmentStatus;
	private int rating;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateOfRelive() {
		return dateOfRelive;
	}
	public void setDateOfRelive(Date dateOfRelive) {
		this.dateOfRelive = dateOfRelive;
	}
	public String getVaccinationStatus() {
		return vaccinationStatus;
	}
	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}
	public boolean isEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(boolean employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Employee(int employeeId, String employeeName, int employeeAge, double employeeSalary, String gender,
			Date dateOfJoining, String designation, Date dateOfRelive, String vaccinationStatus,
			boolean employmentStatus, int rating) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.designation = designation;
		this.dateOfRelive = dateOfRelive;
		this.vaccinationStatus = vaccinationStatus;
		this.employmentStatus = employmentStatus;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeSalary=" + employeeSalary + ", gender=" + gender + ", dateOfJoining=" + dateOfJoining
				+ ", designation=" + designation + ", dateOfRelive=" + dateOfRelive + ", vaccinationStatus="
				+ vaccinationStatus + ", employmentStatus=" + employmentStatus + ", rating=" + rating + "]";
	}
	public Employee() {
		super();
		
	}

}
