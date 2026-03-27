package com.skills.service;

import com.skills.entity.Employee;

public interface EmployeeService {
    void add(Employee e);
    void update(Employee e);
    void delete(int id);
    Employee search(int id);
    void display();
}