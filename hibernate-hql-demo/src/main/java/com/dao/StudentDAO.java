package com.dao;

import com.config.HibernateConfig;
import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

	// 🔹 Save student
	public void saveStudent(Student student) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(student);

		tx.commit();
		session.close();
	}

	// 🔹 Fetch all students
	public List<Student> getAllStudents() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		List<Student> list = session.createQuery("FROM Student", Student.class).list();
		session.close();
		return list;
	}

	// 🔹 Fetch students with marks greater than a value
	public List<Student> getStudentsWithHighMarks(int marks) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		List<Student> list = session.createQuery("FROM Student WHERE marks > :marks", Student.class)
				.setParameter("marks", marks).list();
		session.close();
		return list;
	}

	// 🔹 Fetch student by roll number
	public Student getStudentByRollNo(int rollno) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Student student = session.createQuery("FROM Student WHERE rollno = :rollno", Student.class)
				.setParameter("rollno", rollno).uniqueResult();
		session.close();
		return student;
	}

	// 🔹 Update marks by name
	public void updateMarksByName(String name, int marks) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.createQuery("UPDATE Student SET marks = :marks WHERE name = :name").setParameter("marks", marks)
				.setParameter("name", name).executeUpdate();

		tx.commit();
		session.close();
	}

	// 🔹 Update marks by roll number
	public void updateMarksByRollNo(int rollno, int marks) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.createQuery("UPDATE Student SET marks = :marks WHERE rollno = :rollno").setParameter("marks", marks)
				.setParameter("rollno", rollno).executeUpdate();

		tx.commit();
		session.close();
	}

	// 🔹 Delete students with low marks
	public void deleteLowMarks(int marks) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.createQuery("DELETE FROM Student WHERE marks < :marks").setParameter("marks", marks).executeUpdate();

		tx.commit();
		session.close();
	}

	// 🔹 Delete student by roll number
	public void deleteByRollNo(int rollno) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.createQuery("DELETE FROM Student WHERE rollno = :rollno").setParameter("rollno", rollno)
				.executeUpdate();

		tx.commit();
		session.close();
	}
}