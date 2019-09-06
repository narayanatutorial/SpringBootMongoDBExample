package com.narayanatutorial.SpringBootMongoDBExample;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> , EmployeeRepositoryCustom{

	Employee findByName(String name);
	Employee findByNameAndCity(String name,String city);
	Employee findBy_id(ObjectId _id);
}
