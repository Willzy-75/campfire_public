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
	private String url;
	private String packageName;
	private String name;
	private String outputDirectory;

	public TestSuite() {

	}

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
