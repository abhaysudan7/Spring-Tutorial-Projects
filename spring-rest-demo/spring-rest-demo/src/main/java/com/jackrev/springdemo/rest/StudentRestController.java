package com.jackrev.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackrev.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostContruct to load the student data...only once

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Anshul", "Chandel"));
		theStudents.add(new Student("Venkat", "Kataria"));
		theStudents.add(new Student("Kanishk", "Gunsola"));
	}

	// define endpoint for "/students" -return list of students

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

	// define endpoint for "/students/{studentId}" - return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return theStudents.get(studentId);
	}

	

}
