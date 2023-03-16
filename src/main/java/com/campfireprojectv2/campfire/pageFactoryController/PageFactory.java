package com.campfireprojectv2.campfire.pageFactoryController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PageFactory {

	@Id
	@GeneratedValue
	private int id;
	
	private String url;
	private String packageName;
	private String name;
	private String outputDirectory;
	
	public PageFactory() {
		
	}

	public PageFactory(int id, String url, String packageName, String name, String outputDirectory) {
		super();
		this.id = id;
		this.url = url;
		this.packageName = packageName;
		this.name = name;
		this.outputDirectory = outputDirectory;
	}

	@Override
	public String toString() {
		return "PageFactory [id=" + id + ", url=" + url + ", packageName=" + packageName + ", file name=" + name
				+ ", outputDirectory=" + outputDirectory + "]";
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
		
}
