package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "designation", length = 50)
    private String designation;

    @Column(name = "salary", precision = 10, scale = 2)
    private double salary;

    @Column(name = "phoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "address", length = 255)
    private String address;

    // Default Constructor (Required by Hibernate)
    public Employees() {
    }

    // Parameterized Constructor
    public Employees(int id, String name, String email, String department, 
                     String designation, double salary, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Employees [id=" + id + ", name=" + name + ", department=" + department + 
               ", designation=" + designation + ", salary=" + salary + "]";
    }
}