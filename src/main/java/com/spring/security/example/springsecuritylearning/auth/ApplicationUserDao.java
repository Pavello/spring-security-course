package com.spring.security.example.springsecuritylearning.auth;

import java.util.Optional;

public interface ApplicationUserDao {

	Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
