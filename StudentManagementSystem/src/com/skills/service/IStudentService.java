package com.skills.service;

import com.skills.model.Student;

public interface IStudentService {

    void addStudent(Student s);

    void displayStudents();

    void filterTopStudents();

    void filterFailedStudents();

    void filterByCourse(String course);

    void searchByName(String name);
}