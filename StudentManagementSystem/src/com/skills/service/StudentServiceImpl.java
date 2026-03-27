package com.skills.service;

import com.skills.model.Student;

public class StudentServiceImpl implements IStudentService {

    private Student[] students = new Student[100];
    private int count = 0;

    @Override
    public void addStudent(Student s) {
        if (count < students.length) {
            students[count++] = s;
            System.out.println("Student Added Successfully!");
        } else {
            System.out.println("Storage Full!");
        }
    }

    @Override
    public void displayStudents() {
        if (count == 0) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void filterTopStudents() {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getMarks() > 80) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) System.out.println("No students with marks > 80.");
    }

    @Override
    public void filterFailedStudents() {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getMarks() < 35) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) System.out.println("No failed students.");
    }

    @Override
    public void filterByCourse(String course) {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getCourseEnrolled().equalsIgnoreCase(course)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) System.out.println("No students found in this course.");
    }

    @Override
    public void searchByName(String name) {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getName().equalsIgnoreCase(name)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) System.out.println("Student not found.");
    }
}