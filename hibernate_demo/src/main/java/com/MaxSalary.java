package com;

import java.util.List;

public class MaxSalary {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        
        double maxSalary = service.maxSalary();
        
        System.out.println(maxSalary);
    }
}
