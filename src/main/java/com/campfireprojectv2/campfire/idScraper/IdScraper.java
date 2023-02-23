package com.campfireprojectv2.campfire.idScraper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class IdScraper {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String url;
	
	public IdScraper() {
		
	}

	public IdScraper(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		
	}

	@Override
	public String toString() {
		return "IdScraper [id=" + id + ", url=" + url + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
		
}
