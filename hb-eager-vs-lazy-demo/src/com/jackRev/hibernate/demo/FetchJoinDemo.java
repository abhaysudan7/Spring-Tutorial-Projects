package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// option 2: HQL query

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id =:theInstructorId",
					Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			Instructor tempInstructor = query.getSingleResult();

			System.out.println("jackRev : Instructor: " + tempInstructor);

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
