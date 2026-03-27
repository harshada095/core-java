package com.skills.service;

import java.util.*;
import com.skills.entity.Student;
import com.skills.validations.StudentValidation;
import com.skills.exceptions.InvalidDataException;

public class StudentServiceImpl implements StudentService {

    Map<Integer, Student> map = new HashMap<>();

    public void add(Student s) {
        try {
            StudentValidation.validate(s);
            map.put(s.getId(), s);
            System.out.println("Added");
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Student s) {
        map.put(s.getId(), s);
    }

    public void delete(int id) {
        map.remove(id);
    }

    public Student get(int id) {
        return map.get(id);
    }

    public void display() {
        map.values().forEach(System.out::println);
    }
}