package com.jackRev.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			// query students: last name = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Sharma'").getResultList();

			// display students
			System.out.println("\nStudent having last name 'Sharma'");
			displayStudents(theStudents);

			// query students: lastname = 'sharma' or firstname = 'Anshul'
			theStudents = session.createQuery("from Student s where s.lastName = 'Sharma' OR s.firstName = 'Anshul'")
					.getResultList();

			// display
			System.out.println("\nStudents with last name 'Sharma' or first name 'Anshul'");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	public static void displayStudents(List<Student> theStudents) {
		// display the students
		for (Student student : theStudents)
			System.out.println("Student : " + student);
	}

}
