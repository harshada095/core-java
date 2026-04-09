package com;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.config.HibernateConfig; // Adjust based on your actual package name
import com.entity.Student;

public class Test {

    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Insert data
        Transaction tx = session.beginTransaction();
        Student stu1 = new Student(101, "Akshay Supekar", "Pune", "akshay@example.com");
        Student stu2 = new Student(102, "Rohit Sharma", "Mumbai", "rohit@example.com");
        Student stu3 = new Student(103, "Priya Singh", "Delhi", "priya@example.com");
        Student stu4 = new Student(104, "Neha Patel", "Ahmedabad", "neha@example.com");
        Student stu5 = new Student(105, "Vikram Joshi", "Bangalore", "vikram@example.com");

        // Saving all students
        session.save(stu1);
        session.save(stu2);
        session.save(stu3);
        session.save(stu4);
        session.save(stu5);
 
        tx.commit();
        System.out.println("Data inserted successfully using constructor!");

        // Retrieve all data
        Query query = session.getNamedQuery("selectAllData");
        List<Student> list = query.list();
        for (Student s : list) {
            System.out.println(s);
        }

        // Update data
        Transaction txUpdate = session.beginTransaction();
        Query namedQuery = session.getNamedQuery("updateData");
        namedQuery.setParameter(1, "Mumbai");
        namedQuery.setParameter(2, "abc@gmail.com");
        namedQuery.setParameter(3, 22); 
        int result = namedQuery.executeUpdate();
        txUpdate.commit();
        System.out.println("Update Data successful. Rows affected: " + result);

        // Delete data
        Transaction txDelete = session.beginTransaction();
        Query deleteQuery = session.getNamedQuery("deleteData");
        deleteQuery.setParameter("rno", 1);
        int rowCount = deleteQuery.executeUpdate();
        txDelete.commit();
        System.out.println("Rows deleted: " + rowCount);
        
     // Now use the named query "selectByRollNo"
        Query<Student> querybyroll = session.getNamedQuery("selectByRollNo");
        query.setParameter("rno", 105);  

        Student res = querybyroll.uniqueResult();  // returns single student

        if (res != null) {
            System.out.println("Student found:");
            System.out.println("Roll No: " + res.getRollno());
            System.out.println("Name: " + res.getName());
            System.out.println("City: " + res.getAddr());
            System.out.println("Email: " + res.getEmail());
        } else {
            System.out.println("No student found with that roll number.");
        }

        session.close();
        sessionFactory.close();
    }
}