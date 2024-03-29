package com.spring.security.example.springsecuritylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

	@GetMapping("login")
	public String getLoginTemplate() {
		return "login";
	}

	@GetMapping("courses")
	public String getCoursesPage() {
		return "courses";
	}
}
