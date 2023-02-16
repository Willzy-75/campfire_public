package com.campfireprojectv2.campfire.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// this will be in a database: mySQL, Oracle, etc
// initially we'll create a static list then shift to a database (H2, MySQL)

// JPA allows us to map the
// Bean -> to a table in the Database

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	@Size(min=3, message="Enter at least 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Todo() {
		
	}
	
	
	public Todo(int id, String username, String description, 
			LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
