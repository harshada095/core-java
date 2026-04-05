package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateConfig;
import com.entity.Employee;
import com.service.EmployeeService;

public class Test {

	public static void main(String[] args) {

		System.out.println("Hibernate...");
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Employee employee = new Employee("Nita", 30);
		Transaction tr = session.beginTransaction();
		
		session.save(employee);

		tr.commit();
		session.close();
//
//		EmployeeService service = new EmployeeService();
//
//        // Fetch employee by ID
//        Object result = service.getEmployeeById(3); 
//
//        System.out.println(result);

		EmployeeService service = new EmployeeService();

		List<Employee> list = service.getAllEmployees();

		for (Employee emp : list) {
			System.out.println(emp);
		}

		 //🔹 Update
		String updateMsg = service.updateEmployeeById(2, "Kushi", 45);
		System.out.println(updateMsg);

		// 🔹 Delete
		String deleteMsg = service.deleteEmployeeById(5);
		System.out.println(deleteMsg);
		
		List<Employee> list1 = service.getAllEmployees();

		for (Employee emp : list1) {
			System.out.println(emp);
		}

		System.out.println("done...");
	}
}