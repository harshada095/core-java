package studentmanagement;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // POLYMORPHISM (Interface reference)
        StudentOperations service = new StudentService();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Filter Students (Marks > 80)");
            System.out.println("4. Filter Failed Students (Marks < 35)");
            System.out.println("5. Filter by Course");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

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
                    System.out.print("Enter course: ");
                    String c = sc.nextLine();
                    service.filterByCourse(c);
                    break;

                case 6:
                    System.out.print("Enter name: ");
                    String n = sc.nextLine();
                    service.searchByName(n);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}