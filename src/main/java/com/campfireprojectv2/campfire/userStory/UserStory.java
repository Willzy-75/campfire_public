package com.campfireprojectv2.campfire.userStory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserStory {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String persona;
	private String whatToDo;
	private String whyToDo;
	private boolean editable;
	private int complexity;
	
	public UserStory() {
		
	}

	public UserStory(int id, String name, String persona, String whatToDo, String whyToDo, boolean editable,
			int complexity) {
		super();
		this.id = id;
		this.name = name;
		this.persona = persona;
		this.whatToDo = whatToDo;
		this.whyToDo = whyToDo;
		this.editable = editable;
		this.complexity = complexity;
	}

	@Override
	public String toString() {
		return "UserStory [id=" + id + "name=" + name + ", persona=" + persona + ", whatToDo=" + whatToDo + ", whyToDo=" + whyToDo
				+ ", editable=" + editable + ", complexity=" + complexity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getWhatToDo() {
		return whatToDo;
	}

	public void setWhatToDo(String whatToDo) {
		this.whatToDo = whatToDo;
	}

	public String getWhyToDo() {
		return whyToDo;
	}

	public void setWhyToDo(String whyToDo) {
		this.whyToDo = whyToDo;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}
	
}
