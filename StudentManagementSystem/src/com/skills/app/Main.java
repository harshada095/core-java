package com.skills.app;

import com.skills.model.Student;
import com.skills.service.IStudentService;
import com.skills.service.StudentServiceImpl;
import com.skills.utils.InputUtils;

public class Main {

    public static void main(String[] args) {

        IStudentService service = new StudentServiceImpl();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Filter Students (Marks > 80)");
            System.out.println("4. Filter Failed Students");
            System.out.println("5. Filter by Course");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Exit");

            choice = InputUtils.getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    int id = InputUtils.getInt("Enter ID: ");
                    String name = InputUtils.getString("Enter Name: ");
                    double marks = InputUtils.getDouble("Enter Marks: ");
                    int roll = InputUtils.getInt("Enter Roll No: ");
                    String course = InputUtils.getString("Enter Course: ");

                    Student s = new Student(id, name, marks, roll, course);
                    service.addStudent(s);
                    break;

                case 2:
                    service.displayStudents();
                    break;

                case 3:
                    service.filterTopStudents();
                    break;

                case 4:
                    service.filterFailedStudents();
                    break;

                case 5:
                    String c = InputUtils.getString("Enter Course: ");
                    service.filterByCourse(c);
                    break;

                case 6:
                    String n = InputUtils.getString("Enter Name: ");
                    service.searchByName(n);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}