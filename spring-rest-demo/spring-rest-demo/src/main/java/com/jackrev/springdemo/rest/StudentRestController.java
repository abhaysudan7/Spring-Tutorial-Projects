package com.jackrev.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackrev.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" -return list of students

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Anshul", "Chandel"));
		theStudents.add(new Student("Venkat", "Kataria"));
		theStudents.add(new Student("Kanishk", "Gunsola"));

		return theStudents;
	}
}
