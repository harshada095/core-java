package com.service;

import java.util.List;

import com.entity.Employee;
import com.repo.EmployeeRepo;

public class EmployeeService {

	EmployeeRepo repo = new EmployeeRepo();

	public Object getEmployeeById(int eid) {
		Object object = repo.getEmployeeById(eid);
		return object;
	}
	
	public List<Employee> getAllEmployees() {
	    return repo.getAllEmployees();
	}
	
	public String updateEmployeeById(int id, String name, int age) {
	    return repo.updateEmployeeById(id, name, age);
	}
	
	public String deleteEmployeeById(int id) {
	    return repo.deleteEmployeeById(id);
	}
	
}