package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Rajat", "Sharma", "rajat.sharma@abc.com");

			// start transaction
			session.beginTransaction();

			// save student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			// My new code

			// find out the student's id : primary key
			System.out.println("Saved student. Generated id : " + tempStudent.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve studentbased on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get Complete: " + myStudent);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
