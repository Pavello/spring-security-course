package com.spring.security.example.springsecuritylearning.auth;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.spring.security.example.springsecuritylearning.security.ApplicationUserRole;

import static com.spring.security.example.springsecuritylearning.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoImpl implements ApplicationUserDao {

	private List<ApplicationUser> applicationUsers;
	private final PasswordEncoder passwordEncoder;

	public FakeApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.applicationUsers = List.of(
				new ApplicationUser("pawel", passwordEncoder.encode("myPass"), true, true, true, true, STUDENT.getGrantedAuthorities()),
				new ApplicationUser("piotr", passwordEncoder.encode("myPass"), true, true, true, true, ADMIN.getGrantedAuthorities()),
				new ApplicationUser("tomek", passwordEncoder.encode("myPass"), true, true, true, true, ADMINTRAINEE.getGrantedAuthorities())
		);
	}

	public List<ApplicationUser> getApplicationUsers() {
		return applicationUsers;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return applicationUsers.stream().filter(au -> au.getUsername().equals(username)).findFirst();
	}

}
