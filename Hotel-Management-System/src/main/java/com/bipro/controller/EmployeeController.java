package com.bipro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipro.model.Employee;
import com.bipro.model.Response;
import com.bipro.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@PostMapping("/addEmployee")
	public Response addEmployee(@RequestBody Employee emp) {
		Response resp = new Response();
		empRepo.save(emp);
		resp.setResponseValue("Employee added successfully");
		return resp;
	}

	@PostMapping("/reliveEmployee")
	public Response reliveEmployee(@RequestBody int empId) {
		Response resp = new Response();
		empRepo.reliveEmployee(empId, new Date());
		resp.setResponseValue("Employee removed successfully");
		return resp;
	}

}
