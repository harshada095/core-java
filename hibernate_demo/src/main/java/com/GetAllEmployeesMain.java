package com;

import java.util.List;
import com.entity.Employee;
import com.service.EmployeeService;

public class GetAllEmployeesMain {

    public static void main(String[] args) {
        
        EmployeeService service = new EmployeeService();
        
        List<Employee> employees = service.getAllEmployees();
        
        if (employees != null && !employees.isEmpty()) {
            employees.forEach(System.out::println);
        } else {
            System.out.println("No employees found.");
        }
    }
}