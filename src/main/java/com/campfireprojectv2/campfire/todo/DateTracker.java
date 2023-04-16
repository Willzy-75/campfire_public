package com.campfireprojectv2.campfire.todo;

import java.util.Date;

public class DateTracker {

	private Date date;
	private int time;
	
	public DateTracker() {
		
	}

	public DateTracker(Date date, int time) {
		super();
		this.date = date;
		this.time = time;
	}

	// ITEC-445 OBJ05-J Do not return references to private mutable class members
	// Updated getter to fix as shown in example code in standards
	public Date getDate() {
		return (Date)date.clone();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	
}
