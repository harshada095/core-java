package com.skills.service;

import java.util.*;
import com.skills.entity.Employee;
import com.skills.validations.EmployeeValidation;
import com.skills.exceptions.InvalidDataException;

public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> list = new ArrayList<>();

    public void add(Employee e) {
        try {
            EmployeeValidation.validate(e);
            list.add(e);
            System.out.println("Added");
        } catch (InvalidDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Employee e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == e.getId()) {
                list.set(i, e);
            }
        }
    }

    public void delete(int id) {
        list.removeIf(e -> e.getId() == id);
    }

    public Employee search(int id) {
        return list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void display() {
        list.forEach(System.out::println);
    }
}