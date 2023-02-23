package com.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.demo.model.EmployeeModel;
@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeModel, Integer>{
	
	EmployeeModel findByEmail(String email);
	
	EmployeeModel findByEmailAndPassword(String email,String password);

	boolean deleteByEmail(String email);

}
