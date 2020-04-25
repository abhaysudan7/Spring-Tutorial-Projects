package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print instructor detail
			System.out.println("Found Instructor Detail: " + tempInstructorDetail);

			// print assosciated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			// delete instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);

			// remove associated object reference
			// break bi-directional link

			tempInstructorDetail.getInstructor().setInstructorDetail(null);

			session.delete(tempInstructorDetail);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
