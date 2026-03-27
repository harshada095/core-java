package com.skills.app;

import java.util.Scanner;
import com.skills.entity.Employee;
import com.skills.service.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();

        while (true) {
            try {
                System.out.println("\n====== EMPLOYEE MENU ======");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Search Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        service.add(new Employee(sc.nextInt(), sc.next()));
                        break;

                    case 2:
                        service.update(new Employee(sc.nextInt(), sc.next()));
                        break;

                    case 3:
                        service.delete(sc.nextInt());
                        break;

                    case 4:
                        Employee e = service.search(sc.nextInt());
                        if (e != null)
                            System.out.println(e);
                        else
                            System.out.println("Employee Not Found");
                        break;

                    case 5:
                        System.out.println("\n--- Employee List ---");
                        service.display();
                        break;

                    case 6:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}