package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Review;
import com.jackRev.hibernate.demo.entity.Student;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the course
			int theId = 10;

			Course tempCourse = session.get(Course.class, theId);

			// print the course
			System.out.println("Deleting the course...");
			System.out.println(tempCourse);

			// print the course reviews
			System.out.println(tempCourse.getReviews());

			// delete the course
			session.delete(tempCourse);

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
