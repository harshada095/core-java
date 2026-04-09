package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
    @NamedQuery(name = "selectAllData", query = "from Student")
    @NamedQuery(name = "updateData", query = "update Student s set s.addr=?1, s.email=?2 where s.rollno=?3")
    @NamedQuery(name = "deleteData", query = "delete from Student s where s.rollno = :rno")
    @NamedQuery(name = "selectByRollNo", query = "from Student s where s.rollno = :rno") 
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	private String name;
	private String addr;
	private String email;

	// Default Constructor
	public Student() {
	}
	
	public Student(int rollno, String name, String addr, String email) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.addr = addr;
		this.email = email;
	}

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