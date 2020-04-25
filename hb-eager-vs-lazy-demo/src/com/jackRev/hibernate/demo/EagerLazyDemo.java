package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("jackRev : Instructor: " + tempInstructor);

			System.out.println("Courses: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			// close session
			session.close();

			System.out.println("\njackRev: The session is now closed!\n");

			// get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());

			System.out.println("jackRev : Done!");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
