package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.config.HibernateConfig;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

//        // Inserting Data using Named Native Query
//        NativeQuery nativeQuery = session.getNamedNativeQuery("insertData");
//        nativeQuery.setParameter(1, "ak");
//        nativeQuery.setParameter(2, "nagar");
//        nativeQuery.setParameter(3, "ak@gmail.com");
//        nativeQuery.executeUpdate();
//
//        tx.commit();
//        System.out.println("Save Data");

        // Selecting All Data using Named Native Query
        NativeQuery nativeQuerySelect = session.getNamedNativeQuery("selectAllData");
        List<Object[]> obj = nativeQuerySelect.list();

        for (Object[] o : obj) {
            System.out.println(o);
            System.out.println(o[0]); // rollno
            System.out.println(o[1]); // name
            System.out.println(o[2]); // addr
            System.out.println(o[3]); // email
        }
        

        NativeQuery updateQuery = session.getNamedNativeQuery("updateData");
        updateQuery.setParameter(1, "Mumbai"); 
        updateQuery.setParameter(2, 1);        
        int updateCount = updateQuery.executeUpdate();

        tx.commit();
        System.out.println("Rows updated: " + updateCount);
        

        NativeQuery deleteQuery = session.getNamedNativeQuery("deleteData");
        deleteQuery.setParameter(1, 1); 
        int deleteCount = deleteQuery.executeUpdate();

        tx.commit();
        System.out.println("Rows deleted: " + deleteCount);
        
        session.close();
        sessionFactory.close();
    }
}