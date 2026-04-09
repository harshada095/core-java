package com;

import java.util.List;

import com.entity.Employee;
import com.service.EmployeeService;

public class GetTopEmployees {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        // Let's fetch the top 5 employees
        int topCount = 5;
        List<Employee> topEmployees = service.getTopEmployees(topCount);

        System.out.println("--- Top " + topCount + " Employees ---");
        for (Employee emp : topEmployees) {
            System.out.println(emp);
        }
    }
}