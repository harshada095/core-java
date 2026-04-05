package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.entity.Employee;

public class HibernateConfig {

	public static SessionFactory getSessionFactory() {

		SessionFactory sessionFactory = null;

		try {
			Configuration cfg = new Configuration();
			cfg.configure(); // reads hibernate.cfg.xml
			cfg.addAnnotatedClass(Employee.class);

			sessionFactory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}
}