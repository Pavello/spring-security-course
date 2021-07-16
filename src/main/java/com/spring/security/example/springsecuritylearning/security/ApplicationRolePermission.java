package com.spring.security.example.springsecuritylearning.security;

public enum ApplicationRolePermission {
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSES_READ("courses:read"),
	COURSES_WRITE("courses:write"),
	;

	private final String permission;

	ApplicationRolePermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
