package com.skills.service;

import com.skills.entity.Student;

public interface StudentService {
    void add(Student s);
    void update(Student s);
    void delete(int id);
    Student get(int id);
    void display();
}