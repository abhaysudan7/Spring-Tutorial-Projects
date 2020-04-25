package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Review;
import com.jackRev.hibernate.demo.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the student Rajat Sharma from db
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);

			System.out.println("\n Loaded Student : " + tempStudent);
			System.out.println("Course : " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");

			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("\nSaving the courses ...");

			session.save(tempCourse1);
			session.save(tempCourse2);

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
