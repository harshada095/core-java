package com.service;

import com.config.DBConnection;
import com.entity.Employee;

import java.sql.*;

public class EmployeeService {

    // 🔹 ADD
    public void add(Employee emp) {
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

    // 🔹 GET BY ID
    public void getById(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3)
                );
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAll() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("-------------------------------------------------");
            System.out.println("Id\tName\t\tDepartment\tSalary\tAge");
            System.out.println("-------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("department") + "\t\t" +
                        rs.getDouble("salary") + "\t\t" +
                        rs.getInt("age")
                );
            }

            System.out.println("-------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE
    public void update(Employee emp) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE employee SET name=?, department=?, salary=?, age=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getAge());
            ps.setInt(5, emp.getId());

            ps.executeUpdate();
            System.out.println("Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE
    public void delete(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 SEARCH BY NAME
    public void searchByName(String name) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 FILTER SALARY
    public void filterBySalary(double salary) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE salary > ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, salary);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 FILTER DEPARTMENT
    public void filterByDepartment(String dept) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE department=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dept);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 FILTER AGE
    public void filterByAge(int age) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee WHERE age > ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, age);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}