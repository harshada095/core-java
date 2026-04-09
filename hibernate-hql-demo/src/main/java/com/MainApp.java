package com;

import com.dao.StudentDAO;
import com.entity.Student;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // 🔹 Create and save students
        Student s1 = new Student(101, "Alice", 85);
        Student s2 = new Student(102, "Bob", 70);
        Student s3 = new Student(103, "Charlie", 55);

        studentDAO.saveStudent(s1);
        studentDAO.saveStudent(s2);
        studentDAO.saveStudent(s3);

        // 🔹 Fetch all students
        System.out.println("All Students:");
        List<Student> allStudents = studentDAO.getAllStudents();
        allStudents.forEach(student -> System.out.println(student));

        // 🔹 Fetch students with marks greater than 60
        System.out.println("\nStudents with marks > 60:");
        List<Student> highMarkStudents = studentDAO.getStudentsWithHighMarks(60);
        highMarkStudents.forEach(System.out::println);

        // 🔹 Fetch student by roll number
        System.out.println("\nStudent with Roll No 102:");
        Student studentByRollNo = studentDAO.getStudentByRollNo(102);
        System.out.println(studentByRollNo);

        // 🔹 Update marks by name
        studentDAO.updateMarksByName("Charlie", 65);
        System.out.println("\nAfter updating Charlie's marks:");
        studentDAO.getAllStudents().forEach(System.out::println);

        // 🔹 Delete students with marks less than 60
        studentDAO.deleteLowMarks(60);
        System.out.println("\nAfter deleting students with marks < 60:");
        studentDAO.getAllStudents().forEach(System.out::println);

        // 🔹 Delete student by roll number
        studentDAO.deleteByRollNo(101);
        System.out.println("\nAfter deleting student with Roll No 101:");
        studentDAO.getAllStudents().forEach(System.out::println);
    }
}