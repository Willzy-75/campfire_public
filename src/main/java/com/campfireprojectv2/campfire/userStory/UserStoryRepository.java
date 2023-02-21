package com.campfireprojectv2.campfire.userStory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {
	public List<UserStory> findByName(String name);
}
