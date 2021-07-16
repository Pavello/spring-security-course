package com.spring.security.example.springsecuritylearning.students;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

	private final List<Student> STUDENTS = List.of(
			new Student(1L,"Tomasz", "Nowak"),
			new Student(2L,"Tomasz", "Burak"),
			new Student(3L,"Tomasz", "Kowal")
	);

	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable Long studentId) {
		return STUDENTS.stream().filter(s -> s.getId() == studentId).findFirst()
				.orElseThrow(() -> new IllegalStateException("student not found"));
	}
}
