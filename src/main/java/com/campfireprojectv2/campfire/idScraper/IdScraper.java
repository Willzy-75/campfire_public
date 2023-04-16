package com.campfireprojectv2.campfire.idScraper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * IdScraper class used to instantiate an idScraper object which is used to pull
 * the id's from a user provided url
 * 
 * @author willm
 *
 */
@Entity
public class IdScraper {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String url;

	/**
	 * No argument constructor
	 */
	public IdScraper() {

	}

	/**
	 * Full Constructor
	 * 
	 * @param id
	 * @param name
	 * @param url
	 */
	public IdScraper(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;

	}

	/**
	 * Getter method for the id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for the id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter method for url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter method for the url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Getter method for name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
