package studentmanagement;

import java.util.Scanner;

public class StudentManagementSystem {

    static Student[] students = new Student[100]; // Array of objects
    static int count = 0; // Track number of students

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    filterTopStudents();
                    break;

                case 4:
                    filterFailedStudents();
                    break;

                case 5:
                    filterByCourse(sc);
                    break;

                case 6:
                    searchByName(sc);
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

    // 1. Add Student
    public static void addStudent(Scanner sc) {
        if (count >= students.length) {
            System.out.println("Storage full!");
            return;
        }

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        System.out.print("Enter Roll Number: ");
        int rollNum = sc.nextInt();

        System.out.print("Enter Course: ");
        sc.nextLine();
        String course = sc.nextLine();

        students[count++] = new Student(id, name, marks, rollNum, course);

        System.out.println("Student Added Successfully!");
    }

    // 2. Display All Students
    public static void displayStudents() {
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

    // 3. Filter Marks > 80
    public static void filterTopStudents() {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getMarks() > 80) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students with marks > 80.");
        }
    }

    // 4. Filter Failed Students
    public static void filterFailedStudents() {
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getMarks() < 35) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No failed students.");
        }
    }

    // 5. Filter by Course
    public static void filterByCourse(Scanner sc) {
        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getCourseEnrolled().equalsIgnoreCase(course)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found in this course.");
        }
    }

    // 6. Search by Name
    public static void searchByName(Scanner sc) {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getName().equalsIgnoreCase(name)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}