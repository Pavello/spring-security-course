package com.spring.security.example.springsecuritylearning.students;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/api/students")
public class ManagementStudentController {

	private final List<Student> STUDENTS = List
			.of(new Student(1L, "Tomasz", "Nowak"), new Student(2L, "Tomasz", "Burak"), new Student(3L, "Tomasz", "Kowal"));

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudents() {
		return STUDENTS;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void addStudent(@RequestBody Student student) {
		System.out.println(student);
	}

	@DeleteMapping("{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable Long studentId) {
		System.out.println("deleted student with id: " + studentId);
	}

	@PutMapping("{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
		System.out.println("Student with id " + studentId + " updated");
	}
}
