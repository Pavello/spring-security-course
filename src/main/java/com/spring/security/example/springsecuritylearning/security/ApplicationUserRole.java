package com.spring.security.example.springsecuritylearning.security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.spring.security.example.springsecuritylearning.security.ApplicationRolePermission.*;

public enum ApplicationUserRole {
	STUDENT(Collections.emptySet()),
	ADMIN(Stream.of(STUDENT_READ, STUDENT_WRITE, COURSES_READ, COURSES_WRITE).collect(Collectors.toCollection(HashSet::new))),
	ADMINTRAINEE(Stream.of(STUDENT_READ, COURSES_READ).collect(Collectors.toCollection(HashSet::new)));

	private final Set<ApplicationRolePermission> permissions;

	ApplicationUserRole(Set<ApplicationRolePermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationRolePermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissionsSet = getPermissions().stream()
				.map(p -> new SimpleGrantedAuthority(p.getPermission()))
				.collect(Collectors.toSet());
		permissionsSet.add(new SimpleGrantedAuthority("ROLE_" + name()));
		return permissionsSet;
	}
}
