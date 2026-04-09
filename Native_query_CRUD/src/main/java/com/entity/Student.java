package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedNativeQueries({
    @NamedNativeQuery(name = "insertData", query = "insert into student(name,addr,email) values (?1,?2,?3)"),
    @NamedNativeQuery(name = "selectAllData", query = "select * from student"),
    @NamedNativeQuery(name = "updateData", query = "update student set addr=?1 where rollno=?2"),
    @NamedNativeQuery(name = "deleteData", query = "delete from student where rollno=?1")
})

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;
    
    private String name;
    private String addr;
    private String email;

    // Default Constructor
    public Student() {}

    // Getters and Setters
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", addr=" + addr + ", email=" + email + "]";
    }
}