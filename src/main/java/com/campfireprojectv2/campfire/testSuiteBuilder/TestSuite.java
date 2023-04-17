package com.campfireprojectv2.campfire.testSuiteBuilder;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TestSuite {

	@Id
	@GeneratedValue
	private int id;

	// ITEC-445: OBJ01-J Limit accessibility of fields
	// ensured all member fields in the project are private and only accessible using 
	// public getters
	private String url;
	private String packageName;
	private String name;
	private String outputDirectory;

	public TestSuite() {

	}

	// ITEC-445: OBJ11-J be wary of letting constructors throw exceptions.
	// Added checks to ensure all values are non-null before instantiating TestSuite object. 
	public TestSuite(Integer id, String url, String packageName, String name, String outputDirectory) {
		super();
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.url = Objects.requireNonNull(url, "url must not be null");
		this.packageName = Objects.requireNonNull(packageName, "packageName must not be null");
		this.name = Objects.requireNonNull(name, "name must not be null");
		this.outputDirectory = Objects.requireNonNull(outputDirectory, "outputDirectory must not be null");
	}

	@Override
	public String toString() {
		return "PageFactory [id=" + id + ", url=" + url + ", packageName=" + packageName + ", file name=" + name
				+ ", outputDirectory=" + outputDirectory + "]";
	}

	// ITEC-445: MSC56-J detect and remove superfluous code and values.
	// Removed setters since there is never a reason to set these variables as they are only pulled from 
	// the url provided by the user. Under no circumstances are the values ever set by the application 
	// except through instantiation of the class as a whole.
	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getPackageName() {
		return packageName;
	}


	public String getName() {
		return name;
	}


	public String getOutputDirectory() {
		return outputDirectory;
	}
}
