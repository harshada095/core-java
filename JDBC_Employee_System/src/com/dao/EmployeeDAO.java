package com.dao;

import com.config.DBConnection;
import com.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getAge());

            ps.executeUpdate();
            System.out.println("Employee Added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEmployeeById(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            } else {
                System.out.println("Employee Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                );
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateEmployee(Employee emp) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE employee SET name=?, department=?, salary=?, age=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getAge());
            ps.setInt(5, emp.getId());

            ps.executeUpdate();
            System.out.println("Employee Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Employee Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Search by Name
    public void searchByName(String name) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("department") + " " +
                        rs.getDouble("salary") + " " +
                        rs.getInt("age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Filter by Salary > given value
    public void filterBySalary(double salary) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE salary > ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, salary);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getDouble(4) + " " +
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Filter by Department
    public void filterByDepartment(String dept) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE department=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dept);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getDouble(4) + " " +
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Filter by Age
    public void filterByAge(int age) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE age > ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, age);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getDouble(4) + " " +
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}