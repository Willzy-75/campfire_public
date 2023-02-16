package com.campfireprojectv2.campfire.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	// LDAP 
	// Database
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("Will", "Test");
		UserDetails userDetails2 = createNewUser("Client", "Test");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> 
			passwordEncoder().encode(input);
		UserDetails userDetails = User
			.builder()
			.passwordEncoder(passwordEncoder)
			.username(username)
			.password(password)
			.roles("User","ADMIN")
			.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// by default all URLs are protected
	// a login form is shown for unauthorized requests
	// CSRF disable Cross Site Request Forgery
	// Frames by default are not allowed, so we must ensure they are set up.
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// we are ensuring that all requests are authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
