package com.bipro.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bipro.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{


	@Modifying
	@Transactional
	@Query(value="update employee set employmentstatus='false', dor=now() where id=?1",nativeQuery=true)
	public void reliveEmployee(int empId, Date date);

}
