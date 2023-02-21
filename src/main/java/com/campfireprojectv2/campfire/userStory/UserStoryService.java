package com.campfireprojectv2.campfire.userStory;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserStoryService {
	
	private UserStoryRepository userStoryRepository;
	
	public UserStoryService(UserStoryRepository userStoryRepository) {
		this.userStoryRepository=userStoryRepository;
	}
	
	public List<UserStory> findByUserStoryName(String name) {
		return userStoryRepository.findByName(name);
	}
	
	public void addUserStory(UserStory userStory) {
		userStoryRepository.save(userStory);
	}
	
	public void deleteById(int id) {
		userStoryRepository.deleteById(id);
	}

	public UserStory findById(int id) {
		Optional<UserStory> result = userStoryRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	public void updateUserStory(UserStory userStory) {
		userStoryRepository.save(userStory);		
	}
}
