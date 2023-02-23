package com.campfireprojectv2.campfire.idScraper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdScraperRepository extends JpaRepository<IdScraper, Integer>{
	public List<IdScraper> findByName(String name);
}
