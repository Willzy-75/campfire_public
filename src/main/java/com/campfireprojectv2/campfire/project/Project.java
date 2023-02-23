package com.campfireprojectv2.campfire.project;

import com.campfireprojectv2.campfire.client.Client;
import com.campfireprojectv2.campfire.userStory.UserStory;

public class Project {
	private Client client;
	private UserStory userStory;

	public Project(Client client, UserStory userStory) {
		super();
		this.client = client;
		this.userStory = userStory;
	}

	@Override
	public String toString() {
		return "Project [client=" + client + ", userStory=" + userStory + "]";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

}
