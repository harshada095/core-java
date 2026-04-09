package com;

import java.util.List;

import com.entity.Employee;
import com.service.EmployeeService;

public class PaginationTest {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        int recordsPerPage = 5;  // Number of employees per page
        int page = 0;             // Start from page 0 (offset = page * recordsPerPage)

        boolean hasMore = true;

        while (hasMore) {
            int offset = page * recordsPerPage;
            List<Employee> employees = service.getEmployeesByPage(recordsPerPage, offset);

            if (employees.isEmpty()) {
                hasMore = false;
                break;
            }

            System.out.println("Page " + (page + 1) + ":");

            for (Employee emp : employees) {
                System.out.println(
                    "ID: " + emp.getId() +
                    ", Name: " + emp.getName() +
                    ", Age: " + emp.getAge()
                );
            }

            System.out.println("------------------------");

            page++;  // move to next page
        }

        System.out.println("Pagination test completed.");
    }
}