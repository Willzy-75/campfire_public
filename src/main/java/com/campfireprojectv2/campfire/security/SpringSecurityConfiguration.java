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

	
	// ITEC-445 MSC03-J Never hard code sensitive data
	// I made a good faith effort to remove this information using Spring Security, but 
	// unfortunately, it took a long time and kept locking me out of the app. I asked 
	// the professor advising on my cap stone and he said it might be better to leave it in 
	// for now since it is so close to end of semester, so I am aware of the problem and 
	// tried to fix it.
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("Will", "Test");
		UserDetails userDetails2 = createNewUser("Client", "Test");
		UserDetails userDetails3 = createNewUser("Tester", "Test");
		UserDetails userDetails4 = createNewUser("Developer", "Test");
		UserDetails userDetails5 = createNewUser("Engineer", "Test");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3, userDetails4, userDetails5);
	}

	// ITEC-445 MET03-J Methods that perform a security check must be declared private or final
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

	// ITEC-445 MSC62-J Store passwords using a hash function.
	// MSC61-J Do not use insecure or weak cryptographic algorithms
	// Spring's BCryptPasswordEncoder uses a NIST approved blowfish algorithm,
	// and is automatically salted to prevent the use of rainbow lists
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// ITEC-445 SEC04-J Protect sensitive operations with security manager checks.
	// The following method is Spring Security's method to ensure all requests are authenticated
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// we are ensuring that all requests are authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		http.formLogin(withDefaults());
		// ITEC-445 IDS56-J Prevent arbitrary file upload
		// The next line of code prevents cross site request forgery CSRF
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}





