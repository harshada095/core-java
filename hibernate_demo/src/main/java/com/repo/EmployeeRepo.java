package com.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateConfig;
import com.entity.Employee;

public class EmployeeRepo {

	SessionFactory sf = HibernateConfig.getSessionFactory();

	public Object getEmployeeById(int eid) {
		Object object = null;
		try {
			Session session = sf.openSession();
			
			Employee employee = session.get(Employee.class, eid);
			
			if (employee != null) {
				object = employee;
			} else {
				object = "Employee not exist for ID : " + eid;
			}
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public List<Employee> getAllEmployees() {
	    List<Employee> list = null;

	    try {
	        Session session = sf.openSession();

	        // HQL query
	        list = session.createQuery("from Employee", Employee.class).list();

	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	public String updateEmployeeById(int id, String name, int age) {
	    String message = "";

	    try {
	        Session session = sf.openSession();
	        Transaction tr = session.beginTransaction();

	        Employee emp = session.get(Employee.class, id);

	        if (emp != null) {
	            emp.setName(name);
	            emp.setAge(age);

	            session.update(emp);
	            tr.commit();
	            message = "Employee updated successfully";
	        } else {
	            message = "Employee not found with ID: " + id;
	        }

	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return message;
	}
	
	public String deleteEmployeeById(int id) {
	    String message = "";

	    try {
	        Session session = sf.openSession();
	        Transaction tr = session.beginTransaction();

	        Employee emp = session.get(Employee.class, id);

	        if (emp != null) {
	            session.delete(emp);
	            tr.commit();
	            message = "Employee deleted successfully";
	        } else {
	            message = "Employee not found with ID: " + id;
	        }

	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return message;
	}
	
}