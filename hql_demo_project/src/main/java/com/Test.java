package com;

import com.config.HibernateUtil;
import com.entity.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        // 1. Insert demo data
//        session.save(new Students("Alice", 21));
//        session.save(new Students("Bob", 25));
//        session.save(new Students("Charlie", 22));
        
     // Insert new student data
        session.save(new Students("David", 23));
        session.save(new Students("Eva", 20));
        session.save(new Students("Frank", 26));

        tx.commit();

        // 2. HQL select query
        Query<Students> query = session.createQuery("FROM Students WHERE age > 21", Students.class);
        List<Students> students = query.getResultList();
        System.out.println("Students older than 21:");
        for (Students s : students) {
            System.out.println(s);
        }

        // 3. HQL update
        tx = session.beginTransaction();
        Query updateQuery = session.createQuery("UPDATE Students SET age = age + 1 WHERE name = 'Alice'");
        int rowsUpdated = updateQuery.executeUpdate();
        tx.commit();
        System.out.println("Rows updated: " + rowsUpdated);

        // 4. HQL delete
        tx = session.beginTransaction();
        Query deleteQuery = session.createQuery("DELETE FROM Students WHERE name = 'Bob'");
        int rowsDeleted = deleteQuery.executeUpdate();
        tx.commit();
        System.out.println("Rows deleted: " + rowsDeleted);

        session.close();
        HibernateUtil.shutdown();
    }
}