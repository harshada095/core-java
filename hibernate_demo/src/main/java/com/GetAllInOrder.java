package com;

import java.util.List;

import com.entity.Employee;
import com.service.EmployeeService;

public class GetAllInOrder {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        // Fetches employees ordered by age (as defined in the repo)
        List<Employee> all = service.getAllInOrder();

        for (Employee employee : all) {
            System.out.println(employee);
        }
    }
}