package com.campfireprojectv2.campfire.idScraper;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class IdScraperService {

	private IdScraperRepository idScraperRepository;
	
	public IdScraperService(IdScraperRepository idScraperRepository) {
		this.idScraperRepository=idScraperRepository;
	}
	
	public List<IdScraper> findByIdScraperName(String name) {
		return idScraperRepository.findByName(name);
	}
	
	public void addIdScraper(IdScraper idScraper) {
		idScraperRepository.save(idScraper);
	}
	
	public void deleteById(int id) {
		idScraperRepository.deleteById(id);
	}
	
	public IdScraper findById(int id) {
		Optional<IdScraper> result = idScraperRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
	
	public void updateIdScraper(IdScraper idScraper) {
		idScraperRepository.save(idScraper);
	}
}
