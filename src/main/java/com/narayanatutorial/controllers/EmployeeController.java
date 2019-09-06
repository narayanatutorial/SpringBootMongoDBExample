package com.narayanatutorial.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.WriteResult;
import com.narayanatutorial.SpringBootMongoDBExample.Employee;
import com.narayanatutorial.SpringBootMongoDBExample.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/getCityByName/{name}", method = RequestMethod.GET)
	public String getCityByName(@PathVariable("name") String name) {
		Employee emp=employeeRepository.findByName(name);
		return emp.getCity();
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Employee insertData(@RequestBody Employee employee) {
		employee.set_id(ObjectId.get());
		Employee emp=employeeRepository.save(employee);
		
		
		return emp;
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Employee>  getAll() {
		List<Employee> list=employeeRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/getById/{id}", method = RequestMethod.GET)
	public Employee getById(@PathVariable("id") ObjectId  _id) {
		Employee emp=employeeRepository.findBy_id(_id);
		return emp;
	}
}
