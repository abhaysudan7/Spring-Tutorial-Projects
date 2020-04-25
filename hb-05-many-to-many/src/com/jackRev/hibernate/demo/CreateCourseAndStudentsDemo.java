package com.jackRev.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jackRev.hibernate.demo.entity.Course;
import com.jackRev.hibernate.demo.entity.Instructor;
import com.jackRev.hibernate.demo.entity.InstructorDetail;
import com.jackRev.hibernate.demo.entity.Review;
import com.jackRev.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Million Points");

			// save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);

			// create students
			Student tempStudent1 = new Student("Rajat", "Thakur", "rajat.thakur@foo.com");
			Student tempStudent2 = new Student("Rajat", "Sharma", "rajat.sharma@foo.com");

			// add students to course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			// save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());

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
