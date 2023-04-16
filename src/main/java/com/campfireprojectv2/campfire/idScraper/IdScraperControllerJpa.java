package com.campfireprojectv2.campfire.idScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;

@Controller
@SessionAttributes
public class IdScraperControllerJpa {
	
	
	/**
	 * 
	 */
	private IdScraperRepository idScraperRepository;
	
	/**
	 * @param idScraperRepository
	 */
	public IdScraperControllerJpa(IdScraperRepository idScraperRepository) {
		super();
		this.idScraperRepository = idScraperRepository;
	}


	/**
	 * Method used to generate a table of existing idScrapers
	 * @param model
	 * @return List<IdScrapers>
	 */
	@RequestMapping("list-id-scraper")
	public String listAllIdScrapers(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<IdScraper> idScrapers = idScraperRepository.findByName(username);
		model.addAttribute("idScrapers", idScrapers);
		return "listIdScraper";
	}
	

	// ITEC-445 SEC04-J Protect sensitive operations with security manager checks
	// The following code is used to authenticate the user 
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add-id-scraper", method = RequestMethod.GET) 
	public String showNewIdScraperPage(ModelMap model){
		String username = getLoggedInUsername(model);
		IdScraper idScraper = new IdScraper(1, username, "Enter URL");
		model.put("idScraper", idScraper);
		return "idScraper";
	}
	
	/**
	 * @param model
	 * @param idScraper
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "add-id-scraper", method = RequestMethod.POST) 
	public String addNewIdScraperPage(ModelMap model, @Valid IdScraper idScraper, BindingResult result) {
		if (result.hasErrors()) {
			return "idScraper";
		}
		
		idScraperRepository.save(idScraper);
		return "redirect:list-id-scraper";
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping("delete-id-scraper")
	public String deleteIdScraper(@RequestParam int id) {
		idScraperRepository.deleteById(id);
		return "redirect:list-id-scraper";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update-id-scraper", method = RequestMethod.GET)
	public String showUpdateIdScraperPage(@RequestParam int id, ModelMap model) {
		IdScraper idScraper = idScraperRepository.findById(id).get();
		model.addAttribute("idScraper", idScraper);
		return "idScraper";
	}
	
	/**
	 * @param model
	 * @param idScraper
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "update-id-scraper", method = RequestMethod.POST) 
	public String updateIdScraper(ModelMap model, @Valid IdScraper idScraper, BindingResult result) {
		if(result.hasErrors()) {
			return "idScraper";
		}
		idScraperRepository.save(idScraper);
		return "redirect:list-id-scraper";
	}
	
	
	/**
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "run-id-scraper", method = RequestMethod.GET)
	public String scrapeIds(@RequestParam String url, ModelMap model) {
	    List<String> ids = new ArrayList<>();

	    try {
	    	if(!url.startsWith("http://")) {
	    		url = "http://" + url;
	    	}
	        Document doc = Jsoup.connect(url).get();
	        doc.getAllElements().forEach(element -> {
	            String id = element.id();
	            if (!id.isEmpty()) {
	                ids.add(id);
	            }
	        });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    

	    String username = getLoggedInUsername(model);
	    List<IdScraper> idScrapers = idScraperRepository.findByName(username);

	    model.addAttribute("idScrapers", idScrapers);
	    model.addAttribute("url", url);
	    model.addAttribute("ids", ids);


	    return "listIdScraper";
	}
}
