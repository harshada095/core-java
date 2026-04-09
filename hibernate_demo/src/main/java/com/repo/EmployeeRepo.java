package com.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.config.HibernateConfig;
import com.entity.Employee;
import com.entity.Employees;

public class EmployeeRepo {

    SessionFactory sf = HibernateConfig.getSessionFactory();

    // 🔍 Get Employee by ID
    public Object getEmployeeById(int eid) {
        Object object = null;

        try (Session session = sf.openSession()) {

            Employee employee = session.get(Employee.class, eid);

            if (employee != null) {
                object = employee;
            } else {
                object = "Employee not exist for ID : " + eid;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    
    // ✏️ Update Employee
    public String updateEmployeeById(int id, String name, int age) {
        String message = "";

        try (Session session = sf.openSession()) {

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // ❌ Delete Employee
    public String deleteEmployeeById(int id) {
        String message = "";

        try (Session session = sf.openSession()) {

            Transaction tr = session.beginTransaction();

            Employee emp = session.get(Employee.class, id);

            if (emp != null) {
                session.delete(emp);
                tr.commit();
                message = "Employee deleted successfully";
            } else {
                message = "Employee not found with ID: " + id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    // 🔢 Get Employees by Multiple IDs
    public List<Employee> getEmpByMultipleIds(List<Integer> list) {
        List<Employee> employees = null;

        try (Session session = sf.openSession()) {
            employees = session.byMultipleIds(Employee.class).multiLoad(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
 // 📋 Get All Employees (Without HQL)
    public List<Employee> getAllEmployees() {
        List<Employee> empList = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            cq.select(root);

            empList = session.createQuery(cq).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return empList;
    }
    
    public List<Employee> getTopEmployees(int number) {
        List<Employee> employees = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            cq.select(root);

            // Create query and set max results
            Query<Employee> query = session.createQuery(cq);
            query.setMaxResults(number);

            employees = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
 // Get All Employees Ordered by Age Descending
    public List<Employee> getAllInOrder() {
        List<Employee> employees = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            cq.select(root);
            cq.orderBy(cb.desc(root.get("age")));  // Order by age descending

            Query query = session.createQuery(cq);
            employees = query.list();  // returns List<Employee>

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
 // Pagination: get limited number of employees starting from offset
    public List<Employee> pagination(int records, int offset) {
        List<Employee> employees = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            cq.select(root);

            Query query = session.createQuery(cq);
            query.setFirstResult(offset);   // starting row
            query.setMaxResults(records);   // number of records

            employees = query.list();  // returns List<Employee>

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
    public List<Employees> getAllWhoseSalaryMoreThan(double salary) {
        List<Employees> employees = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employees> cq = cb.createQuery(Employees.class);
            Root<Employees> root = cq.from(Employees.class);

            cq.select(root)
              .where(cb.gt(root.get("salary"), salary))
              .orderBy(cb.asc(root.get("salary")));

            employees = session.createQuery(cq).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
    public List<Employees> getEmployeesByDepartmentAndDesignation(String dept, String designation) {
        List<Employees> employees = null;

        try (Session session = sf.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employees> cq = cb.createQuery(Employees.class);
            Root<Employees> root = cq.from(Employees.class);

            Predicate deptPredicate = cb.equal(root.get("department"), dept);
            Predicate designationPredicate = cb.equal(root.get("designation"), designation);

            cq.select(root)
              .where(cb.and(deptPredicate, designationPredicate));

            employees = session.createQuery(cq).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
    
}