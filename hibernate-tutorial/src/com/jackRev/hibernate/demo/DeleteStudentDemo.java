package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve studentbased on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Deleting student...");

			session.delete(myStudent);
			// commit the transaction
			session.getTransaction().commit();

			// new code

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update all students
			System.out.println("Deleting Student with id 2");

			session.createQuery("delete from Student where id=2").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
