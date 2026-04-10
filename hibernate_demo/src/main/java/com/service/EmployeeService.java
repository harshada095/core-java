package com.service;

import java.util.Collections;
import java.util.List;

import com.entity.Employee;
import com.repo.EmployeeRepo;

public class EmployeeService {

    EmployeeRepo repo = new EmployeeRepo();

    // 🔍 Get Employee by ID
    public Object getEmployeeById(int eid) {
        if (eid <= 0) {
            return "Invalid Employee ID";
        }
        return repo.getEmployeeById(eid);
    }

    // ✏️ Update Employee
    public String updateEmployeeById(int id, String name, int age) {

        if (id <= 0) {
            return "Invalid ID";
        }
        if (name == null || name.trim().isEmpty()) {
            return "Invalid Name";
        }
        if (age <= 0) {
            return "Invalid Age";
        }

        return repo.updateEmployeeById(id, name, age);
    }

    // ❌ Delete Employee
    public String deleteEmployeeById(int id) {

        if (id <= 0) {
            return "Invalid ID";
        }

        return repo.deleteEmployeeById(id);
    }

    // 🔢 Get Employees by Multiple IDs
    public List<Employee> getEmpByMultipleIds(List<Integer> list) {

        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }

        // Remove invalid IDs
        list.removeIf(id -> id <= 0);

        if (list.isEmpty()) {
            return Collections.emptyList();
        }

        Collections.sort(list);

        List<Employee> employees = repo.getEmpByMultipleIds(list);

        return (employees != null) ? employees : Collections.emptyList();
    }

    // 📋 Get All Employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return (employees != null) ? employees : Collections.emptyList();
    }

    // 🏆 Get Top N Employees
    public List<Employee> getTopEmployees(int number) {
        if (number <= 0) {
            return Collections.emptyList();
        }
        List<Employee> employees = repo.getTopEmployees(number);
        return (employees != null) ? employees : Collections.emptyList();
    }
    
 // 📋 Get All Employees Ordered by Age Descending
    public List<Employee> getAllInOrder() {
        List<Employee> employees = repo.getAllInOrder();
        return (employees != null) ? employees : Collections.emptyList();
    }
    
 // Pagination: get limited number of employees starting from offset
    public List<Employee> getEmployeesByPage(int records, int offset) {
        if (records <= 0 || offset < 0) {
            return Collections.emptyList();
        }

        List<Employee> employees = repo.pagination(records, offset);
        return (employees != null) ? employees : Collections.emptyList();
            }
    
    public List<Object[]> getSpecificColumnData() {
        
        return repo.getSpecificColumnData();
    }
    public double maxSalary() {
        // Call the method from the repository and return the result
        double max = repo.maxSalary();
        return max;
    }
}
