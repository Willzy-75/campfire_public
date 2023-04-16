package com.campfireprojectv2.campfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CampfireApplication {

	// ITEC-445 OBJ10-J. Do not use public static non-final fields
	// After reading this standard, I used CTRL+H to search the project and removed 
	// all public static final fields
	
	public static void main(String[] args) {
		SpringApplication.run(CampfireApplication.class, args);
	}

}
