package com.main;

import com.entity.Employee;
import com.service.EmployeeService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n***** Employee Management System *****");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee By ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee By ID");
            System.out.println("5. Delete Employee By ID");
            System.out.println("6. Search Employee By Name");
            System.out.println("7. Filter Employees By Salary >");
            System.out.println("8. Filter Employees By Department");
            System.out.println("9. Filter Employees By Age >");
            System.out.println("10. Exit");
            System.out.println("\nEnter Your Choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    service.add(new Employee(id, name, dept, salary, age));
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    service.getById(sc.nextInt());
                    break;
                }

                case 3: {
                    service.getAll();
                    break;
                }

                case 4: {
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter Dept: ");
                    String udept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double usal = sc.nextDouble();

                    System.out.print("Enter Age: ");
                    int uage = sc.nextInt();

                    service.update(new Employee(uid, uname, udept, usal, uage));
                    break;
                }

                case 5: {
                    System.out.print("Enter ID: ");
                    service.delete(sc.nextInt());
                    break;
                }

                case 6: {
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String nameSearch = sc.nextLine();
                    service.searchByName(nameSearch);
                    break;
                }

                case 7: {
                    System.out.print("Enter Minimum Salary: ");
                    double sal = sc.nextDouble();
                    service.filterBySalary(sal);
                    break;
                }

                case 8: {
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    service.filterByDepartment(dept);
                    break;
                }

                case 9: {
                    System.out.print("Enter Minimum Age: ");
                    int age = sc.nextInt();
                    service.filterByAge(age);
                    break;
                }

                case 10: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default: {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }
}