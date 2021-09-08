package com.bipro.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bipro.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer >{

	@Query(value="SELECT * FROM USERDETAILS WHERE MAILID=?1 AND PASSWORD=?2",nativeQuery = true)
	UserModel validateLogin(String mailid, String password);
	

}
