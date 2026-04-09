package com;

import java.util.Arrays;
import java.util.List;
import com.entity.Employee;
import com.service.EmployeeService;

public class GetByMultipleIds {

    public static void main(String[] args) {
        
        EmployeeService service = new EmployeeService();
        
        List<Integer> list = Arrays.asList(2, 3, 1, 4, 10);
        
        List<Employee> employees = service.getEmpByMultipleIds(list);
        
        System.out.println(employees);
    }
}