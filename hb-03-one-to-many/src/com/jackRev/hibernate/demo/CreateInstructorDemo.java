package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects

			Instructor tempInstructor = new Instructor("Vanshaj", "Sharma", "vanshajsharma@abc.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.jackRev.com/youtube",
					"Love 2 code!!");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will also save the details object
			// because of CascadingType.ALL
			//
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
