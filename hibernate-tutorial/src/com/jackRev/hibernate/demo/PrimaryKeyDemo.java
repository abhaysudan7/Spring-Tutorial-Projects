package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// creating 3 student objects
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Mary", "Public", "mary.public@abc.com");
			Student tempStudent2 = new Student("Shantul", "Raina", "shantul.raina@abc.com");
			Student tempStudent3 = new Student("Anshul", "Chandel", "anshul.chandel@abc.com");

			// start transaction
			session.beginTransaction();

			// save student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
