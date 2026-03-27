package com.skills.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skills.entity.Student;
import com.skills.service.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {
            try {
                System.out.println("\n========= STUDENT MENU =========");
                System.out.println("1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Get Student By ID");
                System.out.println("5. Display All Students");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.println("\n--- Add Student ---");
                        System.out.print("Enter ID: ");
                        int id1 = sc.nextInt();

                        System.out.print("Enter Name: ");
                        String name1 = sc.next();

                        System.out.print("Enter Marks: ");
                        double marks1 = sc.nextDouble();

                        service.add(new Student(id1, name1, marks1));
                        break;

                    case 2:
                        System.out.println("\n--- Update Student ---");
                        System.out.print("Enter ID: ");
                        int id2 = sc.nextInt();

                        System.out.print("Enter New Name: ");
                        String name2 = sc.next();

                        System.out.print("Enter New Marks: ");
                        double marks2 = sc.nextDouble();

                        service.update(new Student(id2, name2, marks2));
                        System.out.println("Student Updated");
                        break;

                    case 3:
                        System.out.println("\n--- Delete Student ---");
                        System.out.print("Enter ID: ");
                        int id3 = sc.nextInt();

                        service.delete(id3);
                        System.out.println("Student Deleted");
                        break;

                    case 4:
                        System.out.println("\n--- Get Student ---");
                        System.out.print("Enter ID: ");
                        int id4 = sc.nextInt();

                        Student s = service.get(id4);
                        if (s != null)
                            System.out.println("Found: " + s);
                        else
                            System.out.println("Student Not Found");
                        break;

                    case 5:
                        System.out.println("\n--- All Students ---");
                        service.display();
                        break;

                    case 6:
                        System.out.println("Exiting... Thank You!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please enter correct data type.");
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}