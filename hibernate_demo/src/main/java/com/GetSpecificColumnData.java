package com;

import java.util.List;

public class GetSpecificColumnData {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        List<Object[]> employees = service.getSpecificColumnData();

        for (Object[] objects : employees) {
            System.out.print(objects[0] + "\t");
            System.out.print(objects[1] + "\t");
            System.out.println(objects[2]);
        }
    }
}
