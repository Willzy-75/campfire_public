package com.campfireprojectv2.campfire.pageFactoryController;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PageFactoryRepository extends JpaRepository<PageFactory, Integer>{
	public List<PageFactory> findByName(String name);
}
